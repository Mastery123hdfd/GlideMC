package commands.pilot;

import Buses.CraftBus.CraftBus;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jspecify.annotations.Nullable;

public class Pilot {
    public static LiteralArgumentBuilder<CommandSourceStack> initCommand(){
        return Commands.literal("pilot").executes(Pilot::createCraft);
    }
    private static int createCraft(CommandContext<CommandSourceStack> ctx){
        CommandSender sender = ctx.getSource().getSender();
        @Nullable Entity executor = (Entity)ctx.getSource().getExecutor();

        if(!(executor instanceof Player player)){
            sender.sendPlainMessage("Only players can pilot ships!");
            return Command.SINGLE_SUCCESS;
        } //Catches anyone whose not a pilot
        CraftBus.addCraft(executor);
    }
}
