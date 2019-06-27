package com.shibo.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class testException {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "test")
    public Reason cancel(NullPointerException e){
        Reason reason=new Reason();
        e.printStackTrace();
        return reason;
    }
    @Data
    private class Reason{
        private String name;
        private Integer num;
    }
}
