package Buses.CraftBus;

import Craft.Craft;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class CraftBus implements ApiStatus.NonExtendable {
    private static World world;
    public CraftBus(World w){this.world = w;}
    private  static Map<Craft, Player> CRAFTTABLE = new HashMap<>();
    public static void addCraft(Player executor){
        Craft craft = new Craft(executor, world);
        CRAFTTABLE.put(craft, executor);
    }
    public World getWorld(){
        return world;
    }

    public Map<Craft,Player> getTable(){
        return CRAFTTABLE;
    }

    public void TransferCraft(CraftBus cb, Craft c){
        if (CRAFTTABLE.keySet().contains(c)){
            cb.getTable().put(c, CRAFTTABLE.get(c));
            CRAFTTABLE.remove(c);
        }
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
