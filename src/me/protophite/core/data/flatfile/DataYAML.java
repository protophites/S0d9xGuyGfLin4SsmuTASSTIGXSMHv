package me.protophite.core.data.flatfile;

import me.protophite.core.Core;
import me.protophite.core.data.Database;
import me.protophite.core.data.module.UserData;
import me.protophite.core.items.ProItem;
import me.protophite.core.singleton.CoreManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

public class DataYAML implements Database {

    private Map<UUID, UserData> users = new HashMap<>();
    private ProFolder userDir;

    public DataYAML() {
        FileManager fileManager = CoreManager.get(Core.getInstance(), FileManager.class);
        ProFolder dataDir = new ProFolder(fileManager.getProFolder().getFolder(), "Database", fileManager);
        userDir = new ProFolder(dataDir.getFolder(), "Users", fileManager);

        Set<File> userFiles = userDir.getFiles().keySet();
        for (File file : userFiles) {
            users.put(UUID.fromString(file.getName().replace(".yml", "")), new UserData(userDir.getConfig(file)));
        }
    }
    @Override
    public UserData getUserData(UUID id) {
        return users.get(id);
    }
    @Override
    public void saveUser(UUID id) {
        File file = userDir.getFile(id.toString() + ".yml");
        userDir.save(file, userDir.getConfig(file));
    }
    @Override
    public void saveAll() {
        userDir.saveAll();
    }
    @Override
    public void newUser(UUID id) {
        String sid = id.toString();

        userDir.createFile(sid);

        YamlConfiguration config = userDir.getConfig(sid + ".yml");
        config.set("Staff", false);
        config.set("Balance", 0);
        config.set("Tokens", 0);

        users.put(id, new UserData(config));
    }
}