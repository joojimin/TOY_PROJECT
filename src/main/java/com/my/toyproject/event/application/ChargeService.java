package com.my.toyproject.event.application;

import com.my.toyproject.event.domain.Order;
import com.my.toyproject.event.domain.OrderDeliveryEvent;
import com.my.toyproject.event.domain.OrderPayEvent;
import com.my.toyproject.event.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChargeService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void charge(final long itemId) {
        Order order = orderRepository.save(new Order(itemId));

        order.pay();
        applicationEventPublisher.publishEvent(new OrderPayEvent(this, order));
        order.delivering();
        applicationEventPublisher.publishEvent(new OrderDeliveryEvent(this, order));
    }

}
