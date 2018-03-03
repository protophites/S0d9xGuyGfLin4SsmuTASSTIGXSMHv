package me.protophite.core.items;

import me.protophite.core.messages.mutable.Mutable;
import me.protophite.core.messages.mutable.MutableLine;
import me.protophite.core.utils.StringUtils;
import me.protophite.core.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProLore {

    public static ProLore BROKEN = new ProLore(StringUtils.EMPTY_LIST);

    private List<MutableLine> lore = new ArrayList<>();

    public ProLore(List<String> list){
        for(String line : list){
            lore.add(new MutableLine(Utils.color(line)));
        }
    }

    public List<Mutable> getMutables(){
        List<Mutable> mutables = new ArrayList<>();
        for(MutableLine line : lore){
            for(Mutable m : line.getMutables()){
                mutables.add(m);
            }
        }
        return mutables;
    }

    public List<MutableLine> getMutableLines(){
        return lore;
    }

    public List<String> getStringList(){
        List<String> list = new ArrayList<>();
        for(MutableLine line : lore){
            line.build();
            list.add(line.getCurrent());
        }
        return list;
    }

}
