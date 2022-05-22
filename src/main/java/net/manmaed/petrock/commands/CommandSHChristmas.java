package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHChristmas {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
    return Commands.literal("christmas")
            .requires(cs -> cs.hasPermission(0))
            .executes(ctx -> run(ctx.getSource()));
}

    private static int run(CommandSourceStack source) {
        PRHats.setHat("christmas");
        source.sendSuccess(new TranslatableComponent("petrock.command.sethat.christmas.feedback"), true);
        return 0;
    }
}
