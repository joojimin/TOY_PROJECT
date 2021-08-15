package com.my.toyproject.event.domain;

import com.my.toyproject.event.application.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
@Slf4j
public class DeliveryEventListener {

    private final DeliveryService deliveryService;

    @TransactionalEventListener
    public void process(OrderDeliveryEvent orderDeliveryEvent) {
        log.info("Delivery start");
        deliveryService.delivery(orderDeliveryEvent.getOrder().getId());
        log.info("Delivery end");
    }

}
