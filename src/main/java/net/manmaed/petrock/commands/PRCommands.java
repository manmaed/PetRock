package net.manmaed.petrock.commands;


import com.mojang.brigadier.CommandDispatcher;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.hats.Trolling;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class PRCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(
                Commands.literal(PetRock.MOD_ID)
                        .then(CommandIASP101.register())
                        .then(CommandSetHat.register())
                        .then(CommandHATRELOAD.register())
        );
    }

    public static void registerNomal(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(
                Commands.literal(PetRock.MOD_ID + "_troll")
                        .requires(cs -> cs.hasPermission(0))
                        .executes(ctx -> runTrollDisable(ctx.getSource()))
        );
    }

    private static int runTrollDisable(CommandSourceStack source) {
        if (PRConfig.DISABLE_TROLL.get()) {
            source.sendFailure(Component.translatable("petrock.command.disable.troll.failed.config"));
            return 0;
        }
        if (PetRock.hascommadbeenused() && !PRConfig.DISABLE_TROLL.get()) {
            source.sendFailure(Component.translatable("petrock.command.disable.troll.failed.command"));
            source.sendFailure(Component.translatable("petrock.command.disable.troll.feedback.2").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
            return 0;
        } else {
            PetRock.disable_troll();
            Trolling.endTroll();
            source.sendSuccess(Component.translatable("petrock.command.disable.troll.feedback.1"), true);
            source.sendSuccess(Component.translatable("petrock.command.disable.troll.feedback.2").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED), true);
            return 0;
        }
    }
}
