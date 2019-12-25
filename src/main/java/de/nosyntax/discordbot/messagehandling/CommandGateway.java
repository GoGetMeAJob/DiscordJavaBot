package de.nosyntax.discordbot.messagehandling;

import de.nosyntax.discordbot.model.Command;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "commandGateway",
        defaultRequestChannel = "commandChannel")
public interface CommandGateway {

    @Gateway
    void processCommand(Message<Command> message);

}
