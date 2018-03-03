package me.protophite.core.messages;
/*
    §0	BLACK
    §1	DARK_BLUE
    §2	DARK_GREEN
    §3	DARK_AQUA
    §4	DARK_RED
    §5	DARK_PURPLE
    §6	GOLD
    §7	GRAY
    §8	DARK_GRAY
    §9	BLUE
    §a	GREEN
    §b	AQUA
    §c	RED
    §d	LIGHT_PURPLE
    §e	YELLOW
    §f	WHITE
*/
public enum Messages {
    CERBERUS_ALREADY(true, "§4%cheat% §cis already %status%"),
    CERBERUS_BANNED_USER(true, "§4%violator% §chas been banned for §4%reason%"),
    CERBERUS_PARDON_USER(true, "§2%violator% §ahas been pardoned!"),
    CERBERUS_ACTIVATED(true, "§2%anticheat% §ahas been activated"),
    CERBERUS_DEACTIVATED(true, "§4%anticheat% §chas been deactivated"),
    CERBERUS_STAFF_LOG(true, "§4%violator% §cis performing suspicous activity with §6%type% §cLEVEL=§4%level%"),

    DATA_DIRECTORY_NEW(false, "§2Missing folder for §a%plugin%... §2Creating §a%directory% §2directory now."),
    DATA_FILE_NEW(false, "§2Missing file for §a%plugin%... §2Creating §a%file% §2file now."),
    DATA_FILE_OVERRIDE(false, "§2Overriding %file% for §a%plugin%..."),
    DATA_SQL_ERROR(false, "§4There was a problem while interacting with the SQL server..."),

    CONFIG_ERROR_FORMAT(false, "§4There was an error while loading §c%type% §4in §c%file%  §4PATH=§c%path%"),

    SERVER_PREFIX_CONSOLE(false, "§1[CONSOLE_LOG]"),
    SERVER_PREFIX_CERBERUS(true, "§4[CHANGEME]"),
    SERVER_PREFIX_MAIN(true, "§7[CHANGEME]"),
    SERVER_PREFIX_STAFF(true, "§1[CHANGEME]"),

    SERVER_DISABLE_PLUGIN(false, "§4%plugin% has been disabled due to: %cause%"),

    GAME_NO_PERM(true, "§cYou do not have permission to do this."),
    GAME_INV_FULL(true, "§cYour inventory is full, could not add \"§4%item%§c\" to your inventory.");

    Messages(Boolean write, String msg){
        this.rawMessage = msg;
        this.write = write;
    }

    private final boolean write;
    public boolean shouldWrite(){return write;}
    private String rawMessage;
    public String getRaw(){return rawMessage;}
}
