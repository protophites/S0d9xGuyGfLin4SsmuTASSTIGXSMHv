package me.protophite.core.gui.buttons.listener;

import me.protophite.core.Core;
import me.protophite.core.gui.buttons.Button;
import me.protophite.core.gui.buttons.events.ButtonClickEvent;
import me.protophite.core.gui.inventory.InventoryPage;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class InteractPageListener implements Listener {

    private final static List<InventoryPage> pages = new ArrayList<>();

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        InventoryPage page = findPage(e.getPlayer(), e.getInventory());
        if(page == null)return;

    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e){
        InventoryPage page = findPage(e.getPlayer(), e.getInventory());
        if(page == null)return;
        Player player = (Player)e.getPlayer();


    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player))return;

        Inventory clickedInv = e.getClickedInventory();
        ItemStack stack = e.getCurrentItem();
        Player clicker = (Player)e.getWhoClicked();

        if(stack == null)return;

        for(InventoryPage page : pages){
            if(page.getBukkitInv().equals(clickedInv)){
                Button button = Button.getFromStack(stack);
                if(button == null)return;
                e.setCancelled(true);

                ButtonClickEvent event = new ButtonClickEvent(clicker, page, button);
                Core.getInstance().getServer().getPluginManager().callEvent(event);

                if(!event.isCancelled()){
                    clickedInv.getViewers().stream().filter(human -> human instanceof Player).forEach(human -> {
                        ((Player) human).updateInventory();
                    });
                } else if(event.getCancelCause() != null) {
                    clicker.sendMessage(event.getCancelCause());
                }
            }
        }
    }

    private InventoryPage findPage(HumanEntity e, Inventory i){
        if(e instanceof Player){
            for(InventoryPage page : pages){
                if(page.getBukkitInv().equals(i))return page;
            }
        }
        return null;
    }
    public static void register(InventoryPage page){
        pages.add(page);
    }

}
