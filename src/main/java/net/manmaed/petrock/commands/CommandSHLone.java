package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHLone {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("loneztar")
                .requires(cs -> cs.hasPermission(0))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        if (PRHats.slowpoke) {
            source.sendFailure(Component.translatable("petrock.command.sethat.loneztar.failure"));
        } else {
            PRHats.setHat("loneztar");
            source.sendSuccess(Component.translatable("petrock.command.sethat.loneztar.success"), true);
        }
        return 0;
    }
}
