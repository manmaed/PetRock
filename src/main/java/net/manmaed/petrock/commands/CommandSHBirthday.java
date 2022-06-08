package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHBirthday {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("birthday")
                .requires(cs -> cs.hasPermission(0))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PRHats.setHat("birthday");
        source.sendSuccess(new TranslatableComponent("petrock.command.sethat.brithday.feedback"), true);
        return 0;
    }
}