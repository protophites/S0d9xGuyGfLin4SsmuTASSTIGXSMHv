package me.protophite.core.module;

import me.protophite.core.Core;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    private Map<ProModule, Boolean> modules = new HashMap<>();
    private Core instance;

    public ModuleManager(Core instance){
        this.instance = instance;



    }

}
