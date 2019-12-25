package de.nosyntax.discordbot.config;

import de.nosyntax.discordbot.messagehandler.MessageServiceImpl;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.security.auth.login.LoginException;

@Configuration
public class DiscordConfig {
    @Value("${bot.token}")
    private String stringValue;
    private final MessageServiceImpl messageService;

    @Autowired
    public DiscordConfig(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @Bean
    public JDA jda() throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(stringValue);
        builder.addEventListeners(messageService);
        return builder.build();
    }
}
