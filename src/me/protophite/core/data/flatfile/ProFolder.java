package me.protophite.core.data.flatfile;

import me.protophite.core.Core;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProFolder {

    private Map<File, YamlConfiguration> proFiles = new HashMap<>();
    public Map<File, YamlConfiguration> getFiles(){return proFiles;}

    private FileManager fManager;
    private File myFolder;

    public ProFolder(File parentFolder, String dirName, FileManager fManager){
        this.fManager = fManager;
        myFolder = new File(parentFolder, dirName);
        if(fManager.getDirectory(dirName) == null){
            this.fManager.directories.add(this);
        } else {
            return;
        }

        if(myFolder.mkdirs()){
            System.out.println(myFolder.getName() + " HAS BEEN CREATED!!!");//TODO change this shit
        } else {
            sort(myFolder.listFiles((dir, name) -> !name.equals(".DS_Store")));
        }
    }

    public void saveAll(){
        for(File file : proFiles.keySet()){
            save(file, proFiles.get(file));
        }
    }
    public void createFile(String fileName){
        File file = new File(myFolder, fileName);
        try {
            if(file.createNewFile()){
                Core.LOGGER.sendMessage("§aMissing file for §2" + fManager.getPlugin().getName() + "§a, creating §2" + fileName);
                proFiles.put(file, YamlConfiguration.loadConfiguration(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void sort(File[] files){
        if(files == null)return;
        for(File file : files){
            if(!file.isDirectory()){
                proFiles.put(file, YamlConfiguration.loadConfiguration(file));
            } else if(fManager.getDirectory(file.getName()) == null){
                new ProFolder(myFolder, file.getName(), fManager);
            }
        }
    }
    public void save(File file, YamlConfiguration config){
        try{
            config.save(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public File getFolder(){return myFolder;}

    public File getFile(String name){
        File ret = new File(myFolder, name);
        if(ret.exists()){
            return ret;
        }
        return null;
    }
    public YamlConfiguration getConfig(String fileName){
        return getConfig(new File(myFolder, fileName));
    }
    public YamlConfiguration getConfig(File file){
        return proFiles.get(file);
    }
}