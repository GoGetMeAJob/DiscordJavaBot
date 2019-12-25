package de.nosyntax.discordbot.testutils;

import de.nosyntax.discordbot.messagehandler.MessageServiceImpl;
import net.dv8tion.jda.api.JDA;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.security.auth.login.LoginException;

@TestConfiguration
public class TestDiscordConfig {

    private final MessageServiceImpl messageService;

    @Autowired
    public TestDiscordConfig(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @Bean
    @Primary
    public JDA jda() {
        return Mockito.mock(JDA.class);
    }
}