package me.protophite.core.gui.inventory;

public class InventoryRow {

    private InventoryPage parent;
    private int rowID;
    private InventorySlot[] children = new InventorySlot[9];

    public InventoryRow(InventoryPage parent, int rowID){
        this.parent = parent;
        this.rowID = rowID;
        for(int i = 0; i < 9; i++){
            children[i] = new InventorySlot(this, i);
        }
    }

    public InventoryPage getParent(){return parent;}
    public int getID(){return rowID;}
    public InventorySlot[] getSlots(){return children;}
    public InventorySlot getEmptySlot(){
        for(InventorySlot slot : children){
            if(!slot.isUsed())return slot;
        }
        return null;
    }

}
