package me.protophite.core.data.runnables;

import me.protophite.core.Core;
import org.bukkit.scheduler.BukkitRunnable;

public class FlushRunnable extends BukkitRunnable {

    private Core instance;

    public FlushRunnable(Core instance){
        this.instance = instance;
    }

    @Override
    public void run() {
        //instance.getDataHandler().flushData();
    }

}
