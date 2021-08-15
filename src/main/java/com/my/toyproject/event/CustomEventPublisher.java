package com.my.toyproject.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;


    public void publish(final String message) {
        log.info("publish event");
        applicationEventPublisher.publishEvent(new CustomEvent(this, message));
    }
}
