package me.protophite.core.data.module.listener;

import me.protophite.core.Core;
import me.protophite.core.data.DataManager;
import me.protophite.core.data.Database;
import me.protophite.core.singleton.CoreManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerListener implements Listener {
    private Database data = CoreManager.get(Core.getInstance(), DataManager.class).getDatabase();

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        UUID id = e.getPlayer().getUniqueId();
        if(data.getUserData(id) == null){
            data.newUser(id);
        }
    }
    //FIXME Might have too much IO traffic
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        UUID id = e.getPlayer().getUniqueId();
        data.saveUser(id);
    }
}