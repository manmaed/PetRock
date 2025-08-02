package net.manmaed.petrock.commands.fun;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.fun.ChanceCubes;
import net.manmaed.petrock.fun.FunUtils;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class CommandCC {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("chance-cubes")
                .requires(cs -> cs.hasPermission(4))
                .then(Commands.argument("modInstalled", BoolArgumentType.bool()).executes(ctx -> run(ctx.getSource(), BoolArgumentType.getBool(ctx, "modInstalled"))))
                //.then(Commands.argument("false", BoolArgumentType.bool()).executes(ctx -> run(ctx.getSource(), false)))
                .executes(ctx -> run(ctx.getSource(), null));
    }

    private static int run(CommandSourceStack source, Boolean cubesinstalled) {
        if (!FunUtils.isATrollRunning()) {
            if(cubesinstalled == null) {
                source.sendFailure(Component.translatable("petrock.command.fun.cc.whatone"));
            } else {
                if (ChanceCubes.isRunning()) {
                    source.sendFailure(Component.translatable("petrock.command.fun.cc.failure"));
                } else {
                    source.sendSuccess(() -> Component.translatable("petrock.command.fun.cc.success"), true);
                    Thread chanceCubes = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ChanceCubes.start(source.getLevel(), cubesinstalled);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    chanceCubes.start();
                }
            }
        } else source.sendFailure(Component.translatable("petrock.command.fun.anotherrunning"));
        return 0;
    }
}
