package me.protophite.core.messages.mutable;

public class Mutable {

    //public static Mutable EMPTY = new Mutable("", "");

    private String mutable;
    private String immutable;

    public Mutable(String immutable, String mutable){
        this.mutable = mutable;
        this.immutable = immutable;
    }

    public void setMutable(String mutable){
        this.mutable = mutable;
    }

    public String getImmutable(){return immutable;}
    public String getMutable(){return mutable;}

}
