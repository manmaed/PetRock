package net.manmaed.petrock.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 22/05/2022.
 */
public class CommandHATRELOAD {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("reload").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PRHats.load();
        source.sendSuccess(() -> Component.translatable("petrock.command.reload.feedback"), true);
        return 0;
    }
}
