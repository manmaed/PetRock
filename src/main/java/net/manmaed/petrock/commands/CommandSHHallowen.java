package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHHallowen {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("halloween")
                .requires(cs -> cs.hasPermission(0))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PRHats.setHat("halloween");
        source.sendSuccess(Component.translatable("petrock.command.sethat.halloween.feedback"), true);
        return 0;
    }
}
