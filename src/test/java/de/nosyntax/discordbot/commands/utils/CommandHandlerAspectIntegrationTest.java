package de.nosyntax.discordbot.commands.utils;

import de.nosyntax.discordbot.DiscordBotApplication;
import de.nosyntax.discordbot.model.Command;
import de.nosyntax.discordbot.testutils.TestDiscordConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.entities.ReceivedMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest(classes = {DiscordBotApplication.class, TestDiscordConfig.class})
@ActiveProfiles("test")
class CommandHandlerAspectIntegrationTest {
    @Autowired
    MockCommand mockCommand;

    @Autowired
    private JDA jda;

    @Mock
    ReceivedMessage message;

    @BeforeEach
    void setUp() {
        initMocks(this);

    }

    @Test
    void testHandleCommand_handlesCommand() {
        // Setup
        final Command command = new Command();
        command.setMessage("!mockedCommand test");
        command.setEvent(new MessageReceivedEvent(jda, 0L, message));

        // Run the test
        final String result = mockCommand.handleCommand(command);

        // Verify the results
        assertThat(result).isEqualTo("!mockedCommand test");
    }

    @Test
    void testHandleCommand_notHandlesCommand() {
        // Setup
        final Command command = new Command();
        command.setMessage("!asdf");
        command.setEvent(new MessageReceivedEvent(jda, 0L, message));

        // Run the test
        final String result = mockCommand.handleCommand(command);

        // Verify the results
       assertThat(result).isNull();
    }

}
