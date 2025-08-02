package net.manmaed.petrock.commands;


import com.mojang.brigadier.CommandDispatcher;
import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.commands.fun.CommandFUN;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

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

    public static void registerNormal(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(
                Commands.literal(PetRock.MOD_ID)
                        .requires(cs -> cs.hasPermission(4))
                        .then(CommandFUN.register())
        );
    }

}
