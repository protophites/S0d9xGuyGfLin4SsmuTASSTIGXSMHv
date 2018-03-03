package me.protophite.core.gui.inventory;

import me.protophite.core.gui.GuiEditor;
import me.protophite.core.gui.HotbarEditor;
import me.protophite.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage implements GuiEditor {

    private static List<InventoryPage> serverPages = new ArrayList<>();

    private PageWrap parent;
    private String title;
    private final Inventory inv;
    private final InventoryRow[] children;

    public InventoryPage(String title, int numRows, PageWrap parent){
        this(title, numRows);
        this.parent = parent;
    }
    public InventoryPage(String title, int numRows){
        this.title = Utils.color(title);

        if(numRows > 6 || numRows < 1)numRows = 6;

        inv = Bukkit.createInventory(null, numRows * 9, this.title);

        children = new InventoryRow[numRows];
        for(int i = 0; i < numRows; i++){
            children[i] = new InventoryRow(this, i);
        }

        serverPages.add(this);
    }

    public void setParent(PageWrap wrap){parent = wrap;}
    public String getTitle(){return title;}
    public Inventory getBukkitInv(){return inv;}
    public InventoryRow getRowAt(int i){
        if(i > children.length || i < 0)return null;
        return children[i];
    }
    public InventoryRow[] getRows(){return children;}
    public InventorySlot getEmptySlot(){
        for(InventoryRow row : children){
            InventorySlot slot = row.getEmptySlot();
            if(slot == null)continue;
            return slot;
        }
        return null;
    }

    //Futur feature, it will be awesome
    @Override
    public void setEditor(GuiEditor editor) {}
    @Override
    public GuiEditor getEditor() {
        return null;
    }
    @Override
    public HotbarEditor newInstance() {
        return null;
    }
}
