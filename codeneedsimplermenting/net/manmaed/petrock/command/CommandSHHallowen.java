package net.manmaed.petrock.command;


/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHHallowen {} //TODO: Implement CommandSHHallowen
/*public class CommandSHHallowen implements Command<CommandSource> {
    private static final CommandSHHallowen cmd = new CommandSHHallowen();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("halloween")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if(!PRHats.slowpoke) {
            context.getSource().sendFeedback(new StringTextComponent("Happy Halloween!"), false);
            PRHats.setHat("halloween");
        } else {
            context.getSource().sendFeedback(new StringTextComponent("No custom hat set with Slowpoke mode enabled"), false);
        }
        return 0;
    }
}*/
