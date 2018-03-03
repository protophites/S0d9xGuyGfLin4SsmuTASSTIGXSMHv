package me.protophite.core.gui.runnables;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class OpenInventoryRunnable extends BukkitRunnable {

    private Player p;
    private Inventory inv;

    public OpenInventoryRunnable(Player p, Inventory inv){
        this.p = p;
        this.inv = inv;
    }

    @Override
    public void run() {
        p.openInventory(inv);
    }
}
