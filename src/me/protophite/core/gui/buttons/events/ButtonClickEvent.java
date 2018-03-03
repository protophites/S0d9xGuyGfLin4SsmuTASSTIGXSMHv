package me.protophite.core.gui.buttons.events;

import me.protophite.core.Core;
import me.protophite.core.gui.buttons.Button;
import me.protophite.core.gui.inventory.InventoryPage;
import me.protophite.core.messages.MessageManager;
import me.protophite.core.messages.Messages;
import me.protophite.core.singleton.CoreManager;
import me.protophite.core.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ButtonClickEvent extends Event implements Cancellable {

    private HandlerList handlers = new HandlerList();
    private String cancelCause;
    private InventoryPage page;
    private Button button;
    private Player clicker;
    private Boolean cancelled = false;

    public ButtonClickEvent(Player clicker, InventoryPage page, Button button){
        this.page = page;
        this.button = button;
        this.clicker = clicker;
    }

    public void setCancelCause(String cause){this.cancelCause = cause;}
    public String getCancelCause(){
        MessageManager mm = CoreManager.get(Core.getInstance(), MessageManager.class);
        return mm.getColored("SERVER_PREFIX_MAIN") + StringUtils.color(cancelCause);
    }

    public Player getClicker(){return clicker;}
    public Button getButton(){return button;}
    public InventoryPage getPage(){return page;}

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
