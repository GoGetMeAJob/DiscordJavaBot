# DiscordJavaBot

A small discord boot written in Java.

To start the application add your bot token in src/main/resources/application.properties
under "bot.token=".

You can then build the application or run it from your IDE as any other Spring boot app.


For writing your own command you can take a look at "de/nosyntax/discordbot/commands/PingCommand.java".

@Commands
public class PingCommand  {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @CommandHandler(command = "ping")
    public void handleCommand(Command command) {
        LOG.debug("Received command: {}", command.getMessage());
        command.getEvent().getChannel().sendMessage("Pong!").queue();
    }
}

Basically you just have to annotate the class that contains your commands with @Commands.

A method that handles a specific command needs to be annotated with @CommandHandler(command = "command-keyword"). 
It is important that a command keyword is supplied with the annotation. 
The code inside the method will than be executed as soon as the boot sees this command keyword in a channel.

Your method also needs the "Command command" parameter. This will contain a MessageReceivedEvent and the message that the bot intercepted.

Commands have a prefix that that can be changed in the application.properties. Multiple prefixes are not yet supported.
