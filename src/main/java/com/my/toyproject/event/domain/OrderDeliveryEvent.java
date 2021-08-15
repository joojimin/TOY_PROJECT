package com.my.toyproject.event.domain;

import com.my.toyproject.event.domain.Order;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderDeliveryEvent extends ApplicationEvent {

    private final Order order;

    public OrderDeliveryEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
