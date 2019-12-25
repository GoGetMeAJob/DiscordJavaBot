package de.nosyntax.discordbot.commands.utils;

import de.nosyntax.discordbot.model.Command;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * This aspect checks if a method that is annotated by {@link de.nosyntax.discordbot.commands.utils.CommandHandler}
 * should execute the method. It checks if the message starts with the command prefix amd the set command in the CommandHandler annotation.
 */
@Aspect
@Component
public class CommandHandlerAspect {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String commandPrefix;

    public CommandHandlerAspect(@Value("${bot.command.prefix:!}") String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    @Around("@annotation(de.nosyntax.discordbot.commands.utils.CommandHandler) && args(command,..)")
    public Object handleCommand(ProceedingJoinPoint joinPoint, Command command) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        CommandHandler commandHandler = AnnotationUtils.findAnnotation(method, CommandHandler.class);
        String handlesCommand = commandHandler.command();
        if (command.getMessage().startsWith(commandPrefix + handlesCommand)) {
            LOG.trace("Command handler aspect for [{}] voted affirmative on {} ", handlesCommand, command);
            return joinPoint.proceed();
        }
        return null;
    }
}
