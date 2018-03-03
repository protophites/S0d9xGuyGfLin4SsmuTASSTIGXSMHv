package me.protophite.core.data.flatfile;

import me.protophite.core.Core;
import me.protophite.core.singleton.CoreManager;
import me.protophite.core.utils.Utils;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProConfigs extends CoreManager {

    public ProConfigs(Plugin plugin, ResourceFile[] data){
        super(plugin);

        final FileManager fileManager = CoreManager.get(plugin, FileManager.class);

        final ProFolder myProFolder = fileManager.getDirectory("FrontierCoreFiles");

        final File myFolder = myProFolder.getFolder();

        for(ResourceFile resrc : data){
            final String resource = resrc.getResourcePath();
            final String name = resrc.getFileName();
            final File file = new File(myFolder, name);

            if(resrc.isOverride() && file.delete()){
                Core.LOGGER.sendMessage("§aOverriding §2" + name + "§a in §2" + myFolder.getName() + "...");
            } else if(!file.exists()){
                Core.LOGGER.sendMessage("§aMissing file for §2" + plugin.getName() + "§a, creating §2" + name);
            }

            if(resource != null){
                InputStream is = plugin.getResource(Utils.separate(resource));
                try{
                    FileOutputStream ex = new FileOutputStream(file);
                    byte[] buf = new byte[1024];
                    int len;
                    while((len = is.read(buf)) > 0) {
                        ex.write(buf, 0, len);
                    }
                    ex.close();is.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            } else {
                myProFolder.createFile(file.getName());
            }
        }
        myProFolder.sort(myFolder.listFiles((dir, name) -> !name.equals(".DS_Store")));
    }
}
