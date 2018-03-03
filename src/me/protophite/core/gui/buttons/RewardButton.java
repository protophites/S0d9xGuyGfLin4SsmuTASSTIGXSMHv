package me.protophite.core.gui.buttons;

import me.protophite.core.messages.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RewardButton extends Button {

    public RewardButton(ItemStack stack, List<String> lore, String itemName, String node) {
        super(stack, lore, itemName, node);
    }

}
