package me.protophite.core.gui.buttons;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ToggleButton extends Button {

    private boolean flag;

    public ToggleButton(ItemStack stack, List<String> lore, String itemName, String node, boolean startingValue) {
        super(stack, lore, itemName, node);
        flag = startingValue;
    }

    public ToggleButton(ItemStack stack, String node, boolean startingValue){
        this(stack, stack.getItemMeta().getLore(), stack.getItemMeta().getDisplayName(), node, startingValue);
    }

    public void setBooleanValue(boolean flag){this.flag = flag;}
    public boolean getBooleanValue(){return flag;}

}
