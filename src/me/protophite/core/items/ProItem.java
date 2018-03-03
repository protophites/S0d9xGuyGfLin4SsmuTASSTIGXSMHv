package me.protophite.core.items;

import me.protophite.core.utils.StringUtils;
import me.protophite.core.utils.Utils;
import me.protophite.core.messages.mutable.Mutable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ProItem {

    private final static ProItem BROKEN = new ProItem(new ItemStack(Material.EGG), StringUtils.EMPTY_LIST, "ERROR");

    private ItemStack custom;
    private List<String> rawLore;
    private ProLore customLore;
    private ItemMeta im;

    public ProItem(ItemStack item, List<String> rawLore, String itemName){
        if(item == null)item = BROKEN.getBukkitStack();
        if(rawLore == null)rawLore = BROKEN.getRawLore();
        if(itemName == null)itemName = item.getItemMeta().getDisplayName();

        this.custom = item;
        this.rawLore = rawLore;
        customLore = new ProLore(rawLore);
        this.im = item.getItemMeta();
        setName(itemName);
    }

    public ProItem(ItemStack stack){
        this(stack, stack.getItemMeta().getLore(), stack.getItemMeta().getDisplayName());
    }
    public ProItem(ItemStack item, List<String> rawLore, String itemName, String... placeholders){
        this(item, rawLore, itemName);
        updateLore(placeholders);
    }

    public ItemStack getRawBukkitStack(){return new ItemStack(custom.getType(), custom.getAmount());}
    public List<String> getRawLore(){return rawLore;}
    public ProLore getCustomLore(){return customLore;}
    public void setName(String itemName){
        im.setDisplayName(Utils.color(itemName));
        custom.setItemMeta(im);
    }
    public void setLore(List<String> rawLore, String... placeholders){
        customLore = new ProLore(rawLore);
        if(placeholders.length > 0){
            updateLore(placeholders);
        }
    }
    public void updateLore(String... placeholders){
        if(placeholders.length > 1){
            List<Mutable> mutables = customLore.getMutables();
            int iterate = mutables.size() < placeholders.length ? mutables.size() : placeholders.length;
            for(int i = 0; i < iterate; i++){
                mutables.get(i).setMutable(placeholders[i]);
            }
            im.setLore(customLore.getStringList());
        }
        custom.setItemMeta(im);
    }
    public ItemStack getBukkitStack(){return custom;}
}