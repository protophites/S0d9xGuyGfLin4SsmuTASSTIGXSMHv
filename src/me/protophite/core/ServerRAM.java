package me.protophite.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;

public abstract class ServerRAM {

    private static final DecimalFormat decimal = new DecimalFormat("0.00%");

    private static long totalRam;
    private static long freeRam;

    private static long totalUsage;
    private static long myUsage;
    private static long othersUsage;

    protected static void start(){
        othersUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        totalRam = Runtime.getRuntime().maxMemory();
        final long run = 20*60;
        new BukkitRunnable(){
            @Override
            public void run() {
                totalUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                myUsage = totalUsage - othersUsage;
                freeRam = totalRam - totalUsage;
                //TODO update scoreboard percentage, but for now '/ram' will display usage.
            }
        }.runTaskTimer(Core.getInstance(), run, run);
    }
    public static long getFreeRam(){return freeRam;}
    public static long getTotalRam(){return totalRam;}
    public static long getTotalUsage(){return totalUsage;}
    public static long getMyUsage(){return myUsage;}
    public static long getOthersUsage(){return othersUsage;}

    public static String totalPercent(){return decimal.format((double)totalUsage / totalRam);}
    public static String myPercent(){   return decimal.format((double)myUsage / totalRam);}
    public static String freePercent(){ return decimal.format((double)freeRam / totalRam);}
}