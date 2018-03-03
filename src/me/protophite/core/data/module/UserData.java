package me.protophite.core.data.module;

import org.bukkit.configuration.file.YamlConfiguration;

public class UserData {

    private boolean staff;  public boolean isStaff(){return staff;}
    private long balance;   public long getBalance(){return balance;}
    private int tokens;     public int getTokens(){return tokens;}

    public UserData(YamlConfiguration config){
        staff = config.getBoolean("Staff");
        balance = config.getLong("Balance");
        tokens = config.getInt("Tokens");
        //TODO add to staff in message handler if user is actually staff
        //TODO get player personal chest gui
    }
}