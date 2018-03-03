package me.protophite.core.anticheat.modules.speedmine.listeners;

import me.protophite.core.Core;
import me.protophite.core.anticheat.modules.speedmine.MineData;
import me.protophite.core.data.FlushableData;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SpeedMineCheckEvents implements Listener, FlushableData {

    private final long FLUSH = TimeUnit.MINUTES.toMillis(2);

    private boolean checkInstantBreaks;
    private final Map<Material, Long> materials;
    private static Map<UUID, MineData> data = new HashMap<>();

    private Core instance;

    public SpeedMineCheckEvents(Core instance, Map<Material, Long> mats, boolean checkInstants){
        this.instance = instance;
        materials = mats;
        //instance.getDataHandler().getFlushableDataList().add(this);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e){
        data.put(e.getPlayer().getUniqueId(), new MineData(e.getBlock(), e.getInstaBreak()));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        MineData md = data.get(e.getPlayer().getUniqueId());

        if(md.isInstaBreak()){

        }
        long timeCompleted = md.getMineTime(System.currentTimeMillis());
    }

    @Override
    public void flush() {
        for(UUID uuid : data.keySet()){
            MineData md = data.get(uuid);
            if(System.currentTimeMillis() - md.getStartTime() >= FLUSH){
                data.remove(uuid);
            }
        }
    }

    // FIXME: 18-02-27
    @Override
    public long getFlushTime() {
        return 0;
    }

}
