package me.protophite.core.anticheat.modules.speedmine;

import org.bukkit.block.Block;

public class MineData {

    private boolean instaBreak;
    private final long startTime;
    private final Block block;

    public MineData(Block block, boolean instaBreak){
        startTime = System.currentTimeMillis();
        this.block = block;
        this.instaBreak = instaBreak;

    }

    public boolean isInstaBreak(){return instaBreak;}
    public Block getBlock(){return block;}
    public long getStartTime(){return startTime;}

    public long getMineTime(long endTime){
        return endTime - startTime;
    }
}
