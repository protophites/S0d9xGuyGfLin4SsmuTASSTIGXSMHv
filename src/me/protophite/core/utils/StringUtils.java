package me.protophite.core.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

    public static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("([%][^% ]+[%])");
    public static final List<String> EMPTY_LIST = new ArrayList<>();


    public static String color(String toColor){
        String translated = ChatColor.translateAlternateColorCodes('&', toColor);
        return ChatColor.translateAlternateColorCodes('§', translated);
    }
}
