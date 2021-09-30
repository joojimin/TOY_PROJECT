package com.my.toyproject.event.application;

import com.my.toyproject.event.domain.OrderDeliveryHistory;
import com.my.toyproject.event.infrastructure.DeliveryHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Profile("dev")
@RequiredArgsConstructor
@Service
@Transactional
public class DeliveryService {

    private final DeliveryHistoryRepository deliveryHistoryRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delivery(final long orderId) {
        deliveryHistoryRepository.save(new OrderDeliveryHistory(orderId));
    }
}
