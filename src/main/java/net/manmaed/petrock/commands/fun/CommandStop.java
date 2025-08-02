package net.manmaed.petrock.commands.fun;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.fun.ChanceCubes;
import net.manmaed.petrock.fun.FunUtils;
import net.manmaed.petrock.fun.SelfDestruct;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class CommandStop {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("stop")
                .requires(cs -> cs.hasPermission(4))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        if (FunUtils.isATrollRunning()) {
            source.sendSuccess(() -> Component.translatable("petrock.command.fun.stop.success"), true);
            ChanceCubes.endTrollNoMessage();
            SelfDestruct.endTrollNoMessage();
            FunUtils.aprilFoolsMesage(source.getLevel());
        } else source.sendFailure(Component.translatable("petrock.command.fun.notrunning"));
        return 0;
    }
}
