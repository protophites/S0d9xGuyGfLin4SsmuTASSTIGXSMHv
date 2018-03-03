package me.protophite.core.singleton;

public class Singleton {

    protected Class<?> myClass;
    protected Object myInstance;

    protected Singleton(Class<?> clazz, Object obj){
        this.myClass = clazz;
        this.myInstance = obj;
    }
}
