package com.my.toyproject.event;

import org.springframework.context.ApplicationEvent;

// Event
public class CustomEvent extends ApplicationEvent {

    private final String message;

    public CustomEvent(Object source, final String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
