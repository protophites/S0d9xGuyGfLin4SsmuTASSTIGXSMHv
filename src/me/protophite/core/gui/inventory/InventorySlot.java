package me.protophite.core.gui.inventory;

import me.protophite.core.items.ProItem;
import org.bukkit.inventory.Inventory;

public class InventorySlot {

    private Inventory bukkitInv;
    private int bukkitSlotID;

    private InventoryRow parent;

    private int slotID;
    private ProItem item;

    public InventorySlot(InventoryRow parent, int slotID){
        this.parent = parent;
        this.slotID = slotID;
        bukkitSlotID = parent.getID() * 10 + slotID;
        bukkitInv = parent.getParent().getBukkitInv();
    }

    public InventoryRow getParent(){return parent;}
    public int getSlotID(){return slotID;}
    public int getBukkitSlotID(){return bukkitSlotID;}
    public boolean isUsed(){return item != null;}
    public ProItem getItem(){return item;}
    public void setItem(ProItem item){
        this.item = item;
    }

    public Inventory getBukkitInventory(){
        return bukkitInv;
    }

}
