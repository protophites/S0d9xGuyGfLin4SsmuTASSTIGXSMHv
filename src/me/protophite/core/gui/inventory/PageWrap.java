package me.protophite.core.gui.inventory;

import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PageWrap {
    private static final List<PageWrap> SERVER_CHEST_GUIS = new ArrayList<>();

    private List<InventoryPage> pages = new ArrayList<>();

    public PageWrap(String title, int numPages, int numRows){
        for(int i = 0; i < numPages; i++){
            pages.add(new InventoryPage(title, numRows, this));
        }
        SERVER_CHEST_GUIS.add(this);
    }

    public PageWrap(String mainTitle, List<InventoryPage> pages) {
        this.pages = pages;
        for(InventoryPage page : pages){
            page.setParent(this);
        }
        SERVER_CHEST_GUIS.add(this);
    }

    public static PageWrap getGuiFromInventory(Inventory i){
        for(PageWrap gui : SERVER_CHEST_GUIS){
            for(InventoryPage page : gui.pages){
                if(page.getBukkitInv().equals(i))return gui;
            }
        }
        return null;
    }
    public static List<PageWrap> getServerChests(){return SERVER_CHEST_GUIS;}


}