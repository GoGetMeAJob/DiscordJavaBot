package de.nosyntax.discordbot.messagehandling;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.messaging.Message;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class MessageHandlerImplTest {

    @Mock
    private CommandGateway mockCommandGateway;
    @Mock
    private JDA jda;
    @Mock ReceivedMessage message;

    private MessageHandlerImpl messageHandlerImplUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        messageHandlerImplUnderTest = new MessageHandlerImpl(mockCommandGateway, "!");
    }

    @Test
    void testOnMessageReceived() {
        // Setup
        final MessageReceivedEvent event = new MessageReceivedEvent(jda, 0L, message);
        when(message.getContentRaw()).thenReturn("!ping");

        // Run the test
        messageHandlerImplUnderTest.onMessageReceived(event);

        // Verify the results
        verify(mockCommandGateway).processCommand(any(Message.class));
    }

    @Test
    void testOnMessageReceived_ignoreMessagesWithoutPrefix() {
        // Setup
        final MessageReceivedEvent event = new MessageReceivedEvent(jda, 0L, message);
        when(message.getContentRaw()).thenReturn("ping");

        // Run the test
        messageHandlerImplUnderTest.onMessageReceived(event);

        // Verify the results
        verify(mockCommandGateway, never()).processCommand(any(Message.class));
    }
}
