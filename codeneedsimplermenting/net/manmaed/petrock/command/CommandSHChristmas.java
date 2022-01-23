package net.manmaed.petrock.command;


/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHChristmas {} //TODO: Implement CommandSHChristmas
/*public class CommandSHChristmas implements Command<CommandSource> {
    private static final CommandSHChristmas cmd = new CommandSHChristmas();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("christmas")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        PRHats.setHat("christmas");
        context.getSource().sendFeedback(new StringTextComponent("Happy Christmas!"), false);
        return 0;
    }
}*/
