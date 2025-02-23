package net.manmaed.petrock.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.fun.FunUtils;
import net.manmaed.petrock.fun.SelfDestruct;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.checkerframework.checker.units.qual.C;

public class CommandSD {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("self-destruct")
                .requires(cs -> cs.hasPermission(4))
                .executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        if (!FunUtils.isATrollRunning()) {
            if (SelfDestruct.isRunning()) {
                source.sendFailure(Component.translatable("petrock.command.fun.sd.failure"));
            } else {
                source.sendSuccess(() -> Component.translatable("petrock.command.fun.sd.success"), true);
                Thread selfDestruct = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SelfDestruct.start(source.getLevel());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                selfDestruct.start();
            }
        } else source.sendFailure(Component.translatable("petrock.command.fun.anotherrunning"));
        return 0;
    }
}
