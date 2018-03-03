package me.protophite.core.data.flatfile;

import me.protophite.core.Core;
import me.protophite.core.singleton.CoreManager;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

public class FileManager extends CoreManager {
    public static final File CORE_FOLDER = Core.getInstance().getDataFolder();

    protected final Set<ProFolder> directories = new HashSet<>();

    protected ProFolder myDir;     public ProFolder getProFolder(){return myDir;}
    protected Plugin plugin;     protected Plugin getPlugin(){return plugin;}

    public FileManager(Plugin plugin){
        super(plugin);
        this.plugin = plugin;

        myDir = new ProFolder(CORE_FOLDER, plugin.getName() + "Files", this);
    }

    public Set<ProFolder> getDirectories(){return directories;}
    public ProFolder getDirectory(String name){
        for(ProFolder folder : directories){
            if(folder.getFolder().getName().equalsIgnoreCase(name)){
                return folder;
            }
        }
        return null;
    }
}