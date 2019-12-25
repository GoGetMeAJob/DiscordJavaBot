package de.nosyntax.discordbot.commands.utils;

import de.nosyntax.discordbot.model.Command;

@Commands
public class MockCommand {

    @CommandHandler(command = "mockedCommand")
    public String handleCommand(Command command) {
        return command.getMessage();
    }
}
