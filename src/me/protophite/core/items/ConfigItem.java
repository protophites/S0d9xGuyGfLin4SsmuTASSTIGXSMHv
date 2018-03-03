package me.protophite.core.items;

import me.protophite.core.utils.Utils;
import me.protophite.core.messages.Messages;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ConfigItem extends ProItem {

    public ConfigItem(String fileName, ConfigurationSection section){
        super(getCorrectStack(fileName, section), section.getStringList("Lore"), section.getString("Name"));
    }

    public ConfigItem(String fileName, ConfigurationSection item, List<String> lore, String name){
        super(getCorrectStack(fileName, item), lore, name);
    }

    //Assuming we are using frontier config ItemStack format (AMOUNT:COLOR:MATERIAL)
    private static ItemStack getCorrectStack(String fileName, ConfigurationSection section){
        String path = "ERROR";
        String m = "ERROR";
        if(section != null){
            m = section.getString("Item");
            path = section.getCurrentPath() + ".Item";

            Material mat = Material.getMaterial(m);
            String[] split = m.split(":");

            if(split.length == 1 && mat != null){
                return new ItemStack(mat);
            } else if(split.length == 2) {

                ByteToColor color = ByteToColor.valueOf(split[0]);
                mat = Material.getMaterial(split[1]);

                if(mat != null){

                    if(Utils.isNumeric(split[0])){
                        int amount = Integer.parseInt(split[0]);
                        if(amount > 64)amount = 64;
                        return new ItemStack(mat, amount);
                    } else if(color != null){
                        return new ItemStack(mat, 1, color.getType());
                    }

                }
            } else if(split.length == 3){

                int amount = Utils.isNumeric(split[0]) ? Integer.parseInt(split[0]) : -1;
                byte value = ByteToColor.valueOf(split[1]) != null ? ByteToColor.valueOf(split[1]).getType() : (byte)-1;
                mat = Material.getMaterial(split[2]);

                if(mat != null && amount > 0 && value > 0){
                    if(amount > 64)amount = 64;
                    return new ItemStack(mat, amount, value);
                }
            }
        }

        MessageHandler.log(Messages.CONFIG_ERROR_FORMAT.getColoredMsg(m, fileName, path), true);
        return null;
    }

    public enum ByteToColor{
        ORANGE((byte)1),
        MAGENTA((byte)2),
        LIGHT_BLUE((byte)3),
        YELLOW((byte)4),
        LIME((byte)5),
        PINK((byte)6),
        GRAY((byte)7),
        SILVER((byte)8),
        CYAN((byte)9),
        PURPLE((byte)10),
        BLUE((byte)11),
        BROWN((byte)12),
        GREEN((byte)13),
        RED((byte)14),
        BLACK((byte)15);

        private byte type;

        ByteToColor(byte type){
            this.type = type;
        }

        public byte getType(){return type;}
    }
}
