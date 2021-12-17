package net.manmaed.petrock.command;


/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHLone {} //TODO: Implement
/*public class CommandSHLone implements Command<CommandSource> {
    private static final CommandSHLone cmd = new CommandSHLone();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("loneztar")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if(!PRHats.slowpoke) {
            context.getSource().sendFeedback(new StringTextComponent("Happy Brithday Loneztar!"), false);
            PRHats.setHat("loneztar");
        } else {
            context.getSource().sendFeedback(new StringTextComponent("No custom hat set with Slowpoke mode enabled"), false);
        }
        return 0;
    }
}*/
