package net.manmaed.petrock.command;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.manmaed.petrock.PetRock;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class PRCommands {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdpr = dispatcher.register(Commands.literal(PetRock.MOD_ID)
                //how to add new commad to /petrock
                //.then(CommadA.register(dispatcher)
                .then(CommandSetHat.register(dispatcher))
                .then(CommandIASP101.register(dispatcher))
        );
        dispatcher.register(Commands.literal(PetRock.MOD_ID).redirect(cmdpr));
    }
}
