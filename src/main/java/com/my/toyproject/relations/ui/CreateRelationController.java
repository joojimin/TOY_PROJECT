package com.my.toyproject.relations.ui;


import com.my.toyproject.relations.application.RelationOrderService;
import com.my.toyproject.relations.dto.RelationItemRequestDto;
import com.my.toyproject.relations.dto.RelationItemResponseDto;
import com.my.toyproject.relations.dto.RelationOrderRequestDto;
import com.my.toyproject.relations.dto.RelationUserRequestDto;
import com.my.toyproject.relations.dto.RelationUserResponseDto;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateRelationController {

    private final RelationOrderService relationOrderService;

    @PostMapping("/my-relation/item")
    public ResponseEntity<RelationItemResponseDto> createItem(@RequestBody RelationItemRequestDto relationItemRequestDto) {
        RelationItemResponseDto response = relationOrderService.createItem(relationItemRequestDto);
        URI location = URI.create("/" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @PostMapping("/my-relation/user")
    public ResponseEntity<RelationUserResponseDto> createUser(@RequestBody RelationUserRequestDto relationUserRequestDto) {
        RelationUserResponseDto response = relationOrderService.createUser(relationUserRequestDto);
        URI location = URI.create("/" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @PostMapping("my-relation/order")
    public ResponseEntity<Void> createOrder(@RequestBody RelationOrderRequestDto relationOrderRequestDto) {
        relationOrderService.createOrder(relationOrderRequestDto);
        URI location = URI.create("/" + 1);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("hello world");
    }
}
