package de.nosyntax.discordbot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;

@Configuration
public class CommandChannelConfig {

    @Bean
    public PublishSubscribeChannel commandChannel() {
        return new PublishSubscribeChannel();
    }

}
