package de.nosyntax.discordbot.commands.utils;

import org.springframework.integration.annotation.ServiceActivator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Stereotype annotation for command handlers.
 * Setting a command is required.
 * See  {@link de.nosyntax.discordbot.commands.PingCommand} for an example.
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ServiceActivator()
public @interface CommandHandler {
    String inputChannel() default "commandChannel";
    String command();
}
