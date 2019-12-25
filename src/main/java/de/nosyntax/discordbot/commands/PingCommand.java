package de.nosyntax.discordbot.commands;


import de.nosyntax.discordbot.commands.utils.CommandHandler;
import de.nosyntax.discordbot.commands.utils.Commands;
import de.nosyntax.discordbot.model.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
/*
*
 */
@Commands
public class PingCommand  {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @CommandHandler(command = "ping")
    public void handleCommand(Command command) {
        LOG.debug("Received command: {}", command.getMessage());
        command.getEvent().getChannel().sendMessage("Pong!").queue();
    }
}


