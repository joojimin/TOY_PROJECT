package com.my.toyproject.event.ui;

import com.my.toyproject.event.application.ChargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final ChargeService chargeService;

    @GetMapping("/order/{itemId}")
    public ResponseEntity<Void> charge(@PathVariable long itemId) {
        chargeService.charge(itemId);
        return ResponseEntity.ok().build();
    }

}
