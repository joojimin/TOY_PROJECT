package com.my.toyproject.event.application;

import com.my.toyproject.event.domain.Order;
import com.my.toyproject.event.domain.OrderDeliveryEvent;
import com.my.toyproject.event.domain.OrderPayEvent;
import com.my.toyproject.event.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Profile("dev")
@RequiredArgsConstructor
@Service
public class ChargeService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void charge(final long itemId) {
        Order order = orderRepository.save(new Order(1L, itemId, "1111111"));

        order.pay();
        applicationEventPublisher.publishEvent(new OrderPayEvent(this, order)); // 서버 로그

        order.delivering();
        applicationEventPublisher.publishEvent(new OrderDeliveryEvent(this, order)); // 두레이 훅
    }
}
