package net.manmaed.petrock.commands.fun;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandFUN {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("fun")
                .requires(cs -> cs.hasPermission(4))
                .then(CommandStop.register())
                .then(CommandSD.register())
                .then(CommandCC.register());
    }
}
