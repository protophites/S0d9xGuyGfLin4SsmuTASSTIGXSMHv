package me.protophite.core.gui.buttons.listener;

import org.bukkit.event.Listener;

public class PageSwitchButtonListener implements Listener {
/*
    private Core instance;

    public PageSwitchButtonListener(Core instance){
         this.instance = instance;
    }

    @EventHandler
    public void onClick(ButtonClickEvent e){
        if(e.getButton() instanceof PageSwitchButton){
            Button button = e.getButton();
            Player player = e.getClicker();
            String permission = button.getPermission();
            if(permission.equals("") || player.hasPermission(permission)){
                OpenInventoryRunnable runnable = new OpenInventoryRunnable(player, e.getPage().getData().getInventory());
                runnable.runTaskLater(instance, 1L);
            } else {
                e.setCancelCause(Messages.GAME_NO_PERM.getColoredMsg());
                e.setCancelled(true);
            }
        }
    }
*/
}
