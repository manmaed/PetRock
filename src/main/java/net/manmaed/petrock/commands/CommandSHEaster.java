package net.manmaed.petrock.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHEaster {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
    return Commands.literal("easter")
            .requires(cs -> cs.hasPermission(0))
            .executes(ctx -> run(ctx.getSource()));
}

    private static int run(CommandSourceStack source) {
        PRHats.setHat("easter");
        //"petrock.command.sethat.easter.feedback": "Happy Easter %1$s",
        source.getEntity().getDisplayName();
        source.sendSuccess(Component.translatable("petrock.command.sethat.easter.feedback", source.getDisplayName()), true);
        return 0;
    }
}
