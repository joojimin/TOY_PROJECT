package com.my.toyproject.async;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyAsyncController {

    private final MyAsyncParentService myAsyncParentService;

    @GetMapping("/async-test")
    public ResponseEntity<Void> asyncTest() {
        myAsyncParentService.test();
        return ResponseEntity.ok().build();
    }
}
