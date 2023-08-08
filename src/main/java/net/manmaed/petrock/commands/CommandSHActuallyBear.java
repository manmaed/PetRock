package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHActuallyBear {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("actuallybear")
                .requires(cs -> cs.hasPermission(0))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        if (PRHats.slowpoke) {
            source.sendFailure(Component.translatable("petrock.command.sethat.noslow.failure"));
        } else {
            PRHats.setHat("actuallybear");
            source.sendSuccess(() -> Component.translatable("petrock.command.sethat.actuallybear.success"), true);
        }
        return 0;
    }
}
