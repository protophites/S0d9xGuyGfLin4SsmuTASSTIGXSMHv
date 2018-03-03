package me.protophite.core.messages.mutable;

import me.protophite.core.utils.StringUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class MutableLine {

    private final String raw;
    private String current;

    //TODO not sure to use map or Mutable object
    //private Map<String, String> mutables = new HashMap<>();

    private List<Mutable> mutables = new ArrayList<>();

    public MutableLine(String raw){
        this.raw = raw;
        current = raw;

        String noColors = ChatColor.stripColor(raw);
        Matcher m = StringUtils.PLACEHOLDER_PATTERN.matcher(noColors);

        while(m.find()){
            String placeholder = m.group(1);
            mutables.add(new Mutable(placeholder, ""));
        }
    }

    public void mutate(String... placeholders){
        if(placeholders.length == 0)return;
        int max, wanted, using;
        max = mutables.size();
        wanted = placeholders.length;
        using = max < wanted ? max : wanted;
        for(int i = 0; i < using; i++){
            mutables.get(i).setMutable(placeholders[i]);
        }
        build();
    }

    public List<Mutable> getMutables(){return mutables;}

    public void build(){
        current = raw;
        for(Mutable m : mutables){
            current = current.replace(m.getImmutable(), m.getMutable());
        }
    }

    public String getCurrent(){
        return current;
    }




}
