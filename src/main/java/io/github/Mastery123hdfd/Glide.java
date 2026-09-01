package io.github.Mastery123hdfd;

import Buses.CraftBus.CraftBus;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Server;

public final class Glide extends JavaPlugin {

    @Override
    public void onEnable() {
        World o = Bukkit.getWorld("overworld");
        World n = Bukkit.getWorld("nether");
        World e = Bukkit.getWorld("end");
        CraftBus obus = new CraftBus(o);
        CraftBus nbus = new CraftBus(n);
        CraftBus ebus = new CraftBus(e);
    }

    @Override
    public void onDisable() {

    }
}
