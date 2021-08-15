package com.my.toyproject.event.application;

import com.my.toyproject.event.domain.PayHistory;
import com.my.toyproject.event.infrastructure.PayHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PayService {

    private final PayHistoryRepository payHistoryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void pay(final long orderId) {
        payHistoryRepository.save(new PayHistory(orderId));
    }
}
