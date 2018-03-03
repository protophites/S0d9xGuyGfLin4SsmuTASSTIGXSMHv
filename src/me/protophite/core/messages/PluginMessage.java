package me.protophite.core.messages;

public class PluginMessage {

    private final String msgName; public String getMsgName(){return msgName;}
    private final String msg;     public String getRaw(){return msg;}
    private final boolean write;  public boolean shouldWrite(){return write;}

    public PluginMessage(String msgName, boolean write, String msg){
        this.msg = msg;
        this.write = write;
        this.msgName = msgName;
    }
}
