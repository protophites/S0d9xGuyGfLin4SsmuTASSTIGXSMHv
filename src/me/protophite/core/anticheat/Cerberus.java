package me.protophite.core.anticheat;


import me.protophite.core.data.FlushableData;

public class Cerberus implements FlushableData {
    @Override
    public void flush() {

    }

    @Override
    public long getFlushTime() {
        return 0;
    }
    /*
    public static String PREFIX = Messages.SERVER_PREFIX_CERBERUS.getColoredMsg();

    private boolean ACTIVE;

    private GuiPage mainGui;

    private List<AntiCheat> antiCheats;

    private static Set<UUID> bannedUUIDS = new HashSet<>();
    private static Set<UUID> suspiciousUUUIDS = new HashSet<>();

    private YamlConfiguration config;

    public Cerberus(Core instance){
        //this.instance = instance;

        FrontierFile ff = instance.getConfigHandler().getFrontierFile(instance, ProConfigs.FILE_CERBERUS);

        File file = ff.getFile();
        config = ff.getConfig();

        ACTIVE = config.getBoolean("Active-On-Start");



            Global-Gui-Options:
  Toggle-Button:
    On:
      Item: RED STAINED_GLASS_PANE
    Off:
      Item: GREEN STAINED_GLASS_PANE
    Name: 'Toggle cheat'
    Lore:
    - %flag%
    - Click to toggle



        String basePath = "Global-Gui-Options.Toggle-Button";


        new ConfigItem(file.getName(), config.getConfigurationSection(basePath + ".On"), config.getStringList(basePath + ".Lore"), config.getString(basePath + ".Name"));



        globalEnableButton = new ConfigItem(file.getName(), config.getConfigurationSection(ePath));
        globalDisableButton = new ConfigItem(file.getName(), config.getConfigurationSection(dPath));

        GuiData gData = new GuiData(PREFIX, 2);
        gui = new ChestGui(gData);
    }

    public List<AntiCheat> getAllAntiCheats(){
        return antiCheats;
    }

    public List<AntiCheat> getEnabledCheats(){
        List<AntiCheat> temp = new ArrayList<>();
        for(AntiCheat ac : antiCheats){
            if(ac.isEnabled()){
                temp.add(ac);
            }
        }
        return temp;
    }

    public void loadAntiCheats(){
        if(ACTIVE){
            MessageHandler.log(PREFIX + Messages.CERBERUS_ACTIVATED.getColoredMsg("Cerberus"), false);
            antiCheats = Arrays.asList(new SpeedMine(config.getConfigurationSection("Anti.Speed-Mine")));
            for(AntiCheat ac : antiCheats){
                gui.addItem(ac.getItemGui());
            }
        } else {
            MessageHandler.log(PREFIX + Messages.CERBERUS_DEACTIVATED.getColoredMsg("Cerberus"), false);
        }
    }

    public ChestGui getGui(){return gui;}

    public ProItem getGlobalEnableButton(){return globalEnableButton;}
    public ProItem getGlobalDisableButton(){return globalDisableButton;}

    @Override
    public void flush() {

    }

    @Override
    public long getFlushTime() {
        return 0;
    }
*/
}
