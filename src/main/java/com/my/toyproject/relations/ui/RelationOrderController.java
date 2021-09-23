package com.my.toyproject.relations.ui;

import com.my.toyproject.relations.application.RelationOrderService;
import com.my.toyproject.relations.dto.RelationOrderResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RelationOrderController {

    private final RelationOrderService relationOrderService;

    @GetMapping("/my-relation/order/{orderId}")
    public ResponseEntity<RelationOrderResponseDto> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(relationOrderService.findOrder(orderId));
    }

    @GetMapping("/my-relation/order")
    public ResponseEntity<List<RelationOrderResponseDto>> getOrders() {
        return ResponseEntity.ok(relationOrderService.findAllOrder());
    }
}
