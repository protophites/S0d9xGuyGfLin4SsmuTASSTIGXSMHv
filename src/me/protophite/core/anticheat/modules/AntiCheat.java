package me.protophite.core.anticheat.modules;

import me.protophite.core.gui.buttons.*;
import me.protophite.core.utils.Utils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;

public class AntiCheat implements Listener{
/*
    private boolean ENABLED = false; public boolean isEnabled(){return ENABLED;}

    private String name;

    private GuiPage options; public GuiPage getOptionsMenu(){return options;}
    private PageSwitchButton mainItem;
    private ToggleButton toggleButton;

    private ConfigurationSection section;

    public AntiCheat(ConfigurationSection section){
        this.section = section;

        ENABLED = section.getBoolean("Enabled");
        name = Utils.color(section.getString("Gui.Name"));

        GuiData gData = new GuiData(name + " options", 1);
        options = new GuiPage(gData);

        //ProItem mainItem = new ConfigItem("cerberus.yml" + section.getConfigurationSection(""));

    }

    private String name(){
        return name;
    }


    @EventHandler
    public void onToggle(ButtonClickEvent e){
        Player clicker = e.getClicker();
        GuiPage page = e.getPage();

        boolean silent = Core.getInstance().getMsgHandler().getSilentPlayers().contains(clicker.getUniqueId());

        if(page.equals(options)){
            Button button = e.getButton();
            if(button.equals(toggleButton)){
                boolean current = toggleButton.getBooleanValue();
                toggleButton.setNewMessage();
            }
        }
    }
    */

}
