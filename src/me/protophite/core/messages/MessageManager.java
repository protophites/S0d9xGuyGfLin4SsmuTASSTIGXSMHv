package me.protophite.core.messages;

import me.protophite.core.data.flatfile.FileManager;
import me.protophite.core.messages.mutable.MutableLine;
import me.protophite.core.singleton.CoreManager;
import me.protophite.core.utils.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class MessageManager extends CoreManager{

    private final Map<String, MutableLine> messages = new HashMap<>();

    public MessageManager(Plugin plug, PluginMessage[] msgs){
        super(plug);

        YamlConfiguration msgConf = CoreManager.get(plug, FileManager.class).getProFolder().getConfig("messages.yml");
        if(msgConf == null){
            throw new NullPointerException("No message.yml file found for " + plug.getName());
        }

        for(PluginMessage msg : msgs){
            String name = msg.getMsgName();
            boolean inConf = msgConf.getString(name) != null;
            String using = inConf ? msgConf.getString(name) : msg.getRaw();

            if(msg.shouldWrite() && !inConf){
                msgConf.set(name, using);
            }
            messages.put(name, new MutableLine(using));
        }
    }

    public MutableLine getMutableLine(String msgName){
        return messages.get(msgName);
    }

    public String getColored(String msgName, String... placeholders) {
        messages.get(msgName).mutate(placeholders);
        return StringUtils.color(messages.get(msgName).getCurrent());
    }
}