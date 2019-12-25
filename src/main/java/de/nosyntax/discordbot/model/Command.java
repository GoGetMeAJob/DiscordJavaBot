package de.nosyntax.discordbot.model;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Command {
    private String message;
    private MessageReceivedEvent event;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageReceivedEvent getEvent() {
        return event;
    }

    public void setEvent(MessageReceivedEvent event) {
        this.event = event;
    }

    public Command event(MessageReceivedEvent event){
        setEvent(event);
        return this;
    }

    public Command message(String message){
        setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return "Command{" +
                "message='" + message + '\'' +
                ", event=" + event +
                '}';
    }
}
