package com.my.toyproject.myresponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class MyResponseCustomException extends RuntimeException {

    public MyResponseCustomException(String message) {
        super(message);
        log.error(message);
    }
}
