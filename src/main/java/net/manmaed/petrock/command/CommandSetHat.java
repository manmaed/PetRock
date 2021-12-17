package net.manmaed.petrock.command;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSetHat {} //TODO: Implement
/*public class CommandSetHat implements Command<CommandSource> {
    private static final CommandSetHat cmd = new CommandSetHat();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("sethat")
                .then(CommandSHBirthday.register(dispatcher))
                .then(CommandSHChristmas.register(dispatcher))
                .then(CommandSHBirthday.register(dispatcher))
                .then(CommandSHHallowen.register(dispatcher))
                .then(CommandSHLone.register(dispatcher))
                .then(CommandSHNone.register(dispatcher))
                .requires(cs -> cs.hasPermission(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        return 0;
    }
}*/
