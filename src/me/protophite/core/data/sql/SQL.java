package me.protophite.core.data.sql;

import me.protophite.core.Core;
import me.protophite.core.data.flatfile.FileManager;
import me.protophite.core.singleton.CoreManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.sql.*;

public class SQL{
    public static SQL getSQL(){return Container.instance;}
    private static class Container{private static final SQL instance = new SQL();}

    private static Connection connection;
    private String host, database, username, password;
    private int port;

    private SQL(){
        YamlConfiguration config = CoreManager.get(Core.getInstance(), FileManager.class).getDirectory("FrontierCoreFiles").getConfig("config.yml");

        host = config.getString("MySQL.host");
        database = config.getString("MySQL.database");
        username = config.getString("MySQL.username");
        password = config.getString("MySQL.password");
        port = config.getInt("MySQL.port");

        try {
            openConnection();
        } catch (SQLException | ClassNotFoundException e) {
            Core.LOGGER.sendMessage("Unable to connect to sql database.");
        }
    }

    public static Connection getConnection(){return connection;}

    public void update(PreparedStatement st){
        try{
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String query){
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public ResultSet query(PreparedStatement st) {
        try {
            return st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(){
        try {
            if(connection != null && !connection.isClosed())
                connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        }
    }


}
