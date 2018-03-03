package me.protophite.core.utils;


import me.protophite.core.Core;
import org.bukkit.ChatColor;

import java.io.File;
import java.util.*;

public class Utils {

    public static Random rng = new Random();
    private static Core instance = Core.getInstance();

    public static int findNumeric(String s){
        s = s.replaceAll("[^0-9]+", "");
        return Integer.parseInt(s);
    }

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('§', s);
    }

    public static String separate(String st){
        return st.replaceAll("/", File.separator);
    }

    public static boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static String color(boolean flag){
        return flag ? ChatColor.GREEN + "True" : ChatColor.RED + "False";
    }

}
