package de.nosyntax.discordbot.messagehandler;

import de.nosyntax.discordbot.model.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;


import java.lang.invoke.MethodHandles;


@Service
public class MessageServiceImpl extends ListenerAdapter implements EventListener {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    private final  CommandGateway commandGateway;


    private final String commandPrefix;

    @Autowired
    public MessageServiceImpl(CommandGateway commandGateway,
                              @Value("${bot.command.prefix:!}") String commandPrefix) {
        this.commandGateway = commandGateway;
        this.commandPrefix = commandPrefix;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        LOG.trace("Message received: {}", message);
        if (message.startsWith(commandPrefix)) {
            commandGateway.processCommand(MessageBuilder
                    .withPayload(new Command().event(event).message(message))
                    .build());
        }
    }

}
