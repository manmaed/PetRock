package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHLone {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("loneztar")
                .requires(cs -> cs.hasPermission(0))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) throws CommandSyntaxException {
        if (PRHats.slowpoke) {
            source.getEntity().sendMessage(new TextComponent("No custom hat set with Slowpoke mode enabled"), source.getPlayerOrException().getUUID());
        } else {
            PRHats.setHat("loneztar");
            source.getEntity().sendMessage(new TextComponent("Happy Brithday Loneztar!"), source.getPlayerOrException().getUUID());
        }
        return 0;
    }
}
