package me.protophite.core.items;

import me.protophite.core.utils.Utils;
import me.protophite.core.messages.Messages;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
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
        //TODO Error message
        String msg = "";
        if(section != null) {
            String m = section.getString("Item");
            String path = section.getCurrentPath() + ".Item";
            String[] split = m.split(":");

            Material mat = findMaterial(split);
            byte data = findData(split);
            int amount = findAmount(split);

            if (mat == null){
                //TODO Error message;
                msg = "";
            } else if (data != -1) {
                return new ItemStack(mat, amount, data);
            } else {
                return new ItemStack(mat, amount);
            }
        }
        //TODO Send error message
        return null;
    }

    private static Material findMaterial(String[] split){
        for(String s : split){
            Material ret = Material.getMaterial(s);
            if(ret != null)return ret;
        }
        return null;
    }
    private static byte findData(String[] split){
        for(String s : split){
            byte ret = ByteToColor.getType(s);
            if(ret != -1)return ret;
        }
        return -1;
    }
    private static int findAmount(String[] split){
        for(String s : split){
            if(Utils.isNumeric(s)){
                int ret = Integer.parseInt(s);
                return ret > 64 ? 64 : ret;
            }
        }
        return 1;
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

        public static byte getType(String input){
            for(ByteToColor c : ByteToColor.values()){
                if(c.toString().equals(input))return c.getType();
            }
            return -1;
        }
    }
}
