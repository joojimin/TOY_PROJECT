package com.my.toyproject.myresponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResponseEntityController {


    @GetMapping(value = "/my-response/v1/get")
    public ResponseEntity<String> myV1Get() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping(value = "/my-response/v2/get")
    public ResponseEntity<String> myV2Get() {
        return new ResponseEntity("hello world!", HttpStatus.OK);
    }

    @GetMapping(value = "/my-response/v3/get")
    public ResponseEntity<String> myV3Get() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("test", "hello world!!!!");
        return new ResponseEntity("hello world!", headers, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/my-response/v4/get")
    public String myV4Get() {
        return "hello world!";
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping(value = "/my-response/v5/get")
    public String myV5Get() {
        return "hello world!";
    }

    @ResponseStatus()
    @GetMapping(value = "/my-response/v6/get")
    public String myV6Get() {
        return "hello world!";
    }


    @ResponseStatus()
    @GetMapping(value = "/my-response/v7/get")
    public String myV7Get() {
        throw new MyResponseCustomException("not found!!!!");

//        return "hello world!";
    }
}
