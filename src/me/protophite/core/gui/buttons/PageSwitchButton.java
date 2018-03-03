package me.protophite.core.gui.buttons;

import me.protophite.core.Core;
import me.protophite.core.gui.inventory.InventoryPage;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class PageSwitchButton extends Button implements Listener {
    private InventoryPage page;

    public PageSwitchButton(ItemStack stack, List<String> lore, String itemName, String node) {
        super(stack, lore, itemName, node);
    }
    public PageSwitchButton(ItemStack stack, List<String> lore, String itemName, String node, InventoryPage page) {
        super(stack, lore, itemName, node);
        this.page = page;
    }
    public PageSwitchButton(ItemStack stack, List<String> lore, String itemName, InventoryPage page){
        this(stack, lore, itemName, "", page);
    }
    public PageSwitchButton(ItemStack stack, String node, InventoryPage page){
        this(stack, stack.getItemMeta().getLore(), stack.getItemMeta().getDisplayName(), node, page);
    }
    public PageSwitchButton(ItemStack stack, InventoryPage page){
        this(stack, "", page);
    }

    public InventoryPage getPage(){return page;}

/*
    @Override
    public void execute(InventoryClickEvent e){
        Core instance = Core.getInstance();
        new BukkitRunnable() {
            public void run() {
                e.getWhoClicked().openInventory(page.getBukkitInv());
            }
        }.runTaskLater(instance, 1L);
    }
    */
}
