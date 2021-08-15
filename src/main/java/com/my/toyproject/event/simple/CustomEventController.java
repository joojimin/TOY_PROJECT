package com.my.toyproject.event.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomEventController {

    private final CustomEventPublisher customEventPublisher;

    @PostMapping("/event-test")
    public ResponseEntity<Void> eventPublish(@RequestBody String message) {
        customEventPublisher.publish(message);
        return ResponseEntity.ok().build();
    }
}
