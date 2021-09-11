package com.my.toyproject.event.domain;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMPLETION;

import com.my.toyproject.event.application.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
@Slf4j
public class PayEventListener {

    private final PayService payService;

    @TransactionalEventListener(phase = AFTER_COMPLETION)
    public void process(OrderPayEvent orderPayEvent) {
        log.info("pay start");
        payService.pay(orderPayEvent.getOrder().getId());
        log.info("pay end");
    }
}
