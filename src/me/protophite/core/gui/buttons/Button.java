package me.protophite.core.gui.buttons;

import me.protophite.core.items.ProItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Button extends ProItem {

    private static List<Button> registeredButtons = new ArrayList<>();

    private final String permission;

    public Button(ItemStack stack, List<String> lore, String itemName, String node) {
        super(stack, lore , itemName);
        permission = node;
        registeredButtons.add(this);
    }
    public Button(ItemStack stack, String node){
        this(stack, stack.getItemMeta().getLore(), stack.getItemMeta().getDisplayName(), node);
    }

    public String getPermission(){return permission;}

    public static Button getFromStack(ItemStack stack){
        for(Button butt : registeredButtons){
            if(butt.getBukkitStack().equals(stack))return butt;
        }
        return null;
    }
}
