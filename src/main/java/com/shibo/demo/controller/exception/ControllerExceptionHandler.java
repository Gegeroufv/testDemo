package com.shibo.demo.controller.exception;

import io.swagger.annotations.ResponseHeader;
import org.apache.commons.lang3.RegExUtils;
import org.checkerframework.checker.regex.RegexUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseHeader()
    public ExceptionMsg handlerConstraintViolationException(ConstraintViolationException e){
        System.out.println(e.getConstraintName()+"  "+e.getLocalizedMessage()+" 1");
        System.out.println(e.getSQLException()+" 2");
        System.out.println(e.getCause()+" 3");
        System.out.println(e.getStackTrace()+" 4");
        System.out.println(e.getSQL()+" 5");

        return new ExceptionMsg();
    }
}
