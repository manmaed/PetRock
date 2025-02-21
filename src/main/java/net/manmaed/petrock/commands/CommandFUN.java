package net.manmaed.petrock.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandFUN {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("fun")
                .requires(cs -> cs.hasPermission(4))
                .then(CommandSD.register());
    }
}
