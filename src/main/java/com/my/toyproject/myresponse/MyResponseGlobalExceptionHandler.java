package com.my.toyproject.myresponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyResponseGlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(MyResponseCustomException.class)
    public String myResponseCustomExceptionHandler(MyResponseCustomException ex) {
        return ex.getMessage();
    }

}
