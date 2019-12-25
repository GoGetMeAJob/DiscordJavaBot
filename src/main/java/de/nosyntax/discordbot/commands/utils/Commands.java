package de.nosyntax.discordbot.commands.utils;

import org.springframework.integration.annotation.MessageEndpoint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Stereotype annotation for classes that contain commands
 * Methods that handle specific commands need to be annotated by
 *  {@link de.nosyntax.discordbot.commands.utils.CommandHandler} for an example.
 */
@MessageEndpoint
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Commands {
}
