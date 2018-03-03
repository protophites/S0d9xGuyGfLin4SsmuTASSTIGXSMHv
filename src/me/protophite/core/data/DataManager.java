package me.protophite.core.data;

import me.protophite.core.Core;
import me.protophite.core.data.flatfile.DataYAML;
import me.protophite.core.data.flatfile.ProConfigs;
import me.protophite.core.data.runnables.FlushRunnable;
import me.protophite.core.singleton.CoreManager;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataManager extends CoreManager {
    public static DataManager getInstance(){return singleton.instance;}
    private static class singleton{
        private static DataManager instance = new DataManager(Core.getInstance(), new DataYAML());
    }


    private FlushRunnable flushRunnable;
    private Core instance = Core.getInstance();

    private Database database;

    private List<FlushableData> flushableDataList = new ArrayList<>();

    public DataManager(Plugin plugin, Database database){
        super(plugin);
        this.database = database;

        //TODO Load core messages messages and write in file if needed.

        //TODO Check if messages are loaded...

        flushRunnable = new FlushRunnable(instance);
        long time = TimeUnit.MINUTES.toMillis(1);
        flushRunnable.runTaskTimer(instance, time, time);
    }

    public Database getDatabase(){return database;}
    public FlushRunnable getFlushRunnable(){return flushRunnable;}
    public void flushData(boolean force){
        for(FlushableData toFlush : flushableDataList){
            if(force || toFlush.getFlushTime() < System.currentTimeMillis()){
                toFlush.flush();
            }
        }
    }

    public List<FlushableData> getFlushableDataList(){return flushableDataList;}
}
