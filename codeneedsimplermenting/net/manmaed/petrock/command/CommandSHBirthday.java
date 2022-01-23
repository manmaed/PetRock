package net.manmaed.petrock.command;


/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHBirthday {} //TODO: Implement CommandSHBirthday
/*public class CommandSHBirthday implements Command<CommandSource> {
    private static final CommandSHBirthday cmd = new CommandSHBirthday();

    public static  ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("birthday")
                .requires(cs -> cs.hasPermission(0))
                .executes(cmd);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        PRHats.setHat("birthday");
        //context.getSource().sendFeedback(new StringTextComponent("Happy Christmas!"), false);
        return 0;
    }
}*/
