package de.nosyntax.discordbot.testutils;

import de.nosyntax.discordbot.messagehandling.MessageHandlerImpl;
import net.dv8tion.jda.api.JDA;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestDiscordConfig {

    private final MessageHandlerImpl messageService;

    @Autowired
    public TestDiscordConfig(MessageHandlerImpl messageService) {
        this.messageService = messageService;
    }

    @Bean
    @Primary
    public JDA jda() {
        return Mockito.mock(JDA.class);
    }
}