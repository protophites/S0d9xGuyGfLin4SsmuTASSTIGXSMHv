package me.protophite.core.singleton;

import me.protophite.core.Core;
import me.protophite.core.data.DataManager;
import me.protophite.core.data.Database;
import me.protophite.core.data.flatfile.DataYAML;
import me.protophite.core.data.flatfile.FileManager;
import me.protophite.core.data.flatfile.ProConfigs;
import me.protophite.core.data.flatfile.ResourceFile;
import me.protophite.core.messages.MessageManager;
import me.protophite.core.messages.Messages;
import me.protophite.core.messages.PluginMessage;
import org.apache.commons.lang.IllegalClassException;
import org.bukkit.plugin.Plugin;

import java.util.*;

public abstract class CoreManager {

    private static Map<Plugin, List<Singleton>> singletons = new HashMap<>();

    protected CoreManager(Plugin plugin){
        List<Singleton> singles = singletons.containsKey(plugin) ? singletons.get(plugin) : new ArrayList<>();
        for(Singleton sg : singles){
            if(this.getClass().equals(sg.myClass)){
                throw new IllegalClassException(this.getClass() + " already exists for " + plugin.getName());
            }
        }
        singles.add(new Singleton(this.getClass(), this));
        singletons.put(plugin, singles);
    }

    public static <T> T get(Plugin plugin, Class<T> clazz){
        List<Singleton> singles = singletons.containsKey(plugin) ? singletons.get(plugin) : new ArrayList<>();
        for(Singleton sg : singles){
            if(sg.myClass.equals(clazz)){
                return clazz.cast(sg.myInstance);
            }
        }
        throw new IllegalArgumentException("Could not find " + clazz.getName() + " in " + plugin.getName());
    }

    public static Map<Plugin, List<Singleton>> getSingletons(){
        return singletons;
    }

    protected static void init(){
        Core instance = Core.getInstance();

        ResourceFile[] resrcs = {
                new ResourceFile("config.yml", false),
                new ResourceFile("messages.yml",false),
                new ResourceFile("cerberus.yml", false)
        };

        new FileManager(instance);
        new ProConfigs(instance, resrcs);

        PluginMessage[] messages = new PluginMessage[Messages.values().length];
        for(Messages msg : Messages.values()){
            messages[messages.length] = new PluginMessage(msg.toString(), msg.shouldWrite(), msg.getRaw());
        }

        new MessageManager(instance, messages);
        new DataManager(instance, new DataYAML());
    }
}
