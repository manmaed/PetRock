package net.manmaed.petrock.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petrock.hats.PRHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSetHat {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("sethat")
                .requires(cs -> cs.hasPermission(0))
                .then(CommandSHBirthday.register())
                .then(CommandSHChristmas.register())
                .then(CommandSHHallowen.register())
                .then(CommandSHEaster.register())
                .then(CommandSHTNT.register())
                .then(CommandSHActuallyBear.register())
                .then(CommandSHLone.register())
                .then(CommandSHNone.register());
    }
}
