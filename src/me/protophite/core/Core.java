package me.protophite.core;


import me.protophite.core.singleton.CoreManager;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {

    protected static Core instance;
    public static ConsoleCommandSender LOGGER;

    public void onEnable(){
        ServerRAM.start();

        instance = this;
        LOGGER = getServer().getConsoleSender();

        CoreManager.init();

    }

    public void onDisable(){
        //SQL.getSQL().closeConnection();
        //CoreManager.clean();
        instance = null;
    }

    public static Core getInstance(){
        return instance;
    }

}
