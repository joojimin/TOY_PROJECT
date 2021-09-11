package com.my.toyproject.event.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderPayEvent extends ApplicationEvent {

    private final Order order;

    public OrderPayEvent(Object source, final Order order) {
        super(source);
        this.order = order;
    }
}
