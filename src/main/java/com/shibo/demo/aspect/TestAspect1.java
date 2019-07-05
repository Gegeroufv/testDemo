package com.shibo.demo.aspect;

import com.shibo.demo.utilsTest.httpUtils.HttpUtils;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Order(1)
@Aspect
@Component
public class TestAspect1 {
    @Pointcut("execution(public * com.shibo.demo.controller..*Controller.*(..))")
    public void theSetter(){}

    @Before("theSetter()")
    public void before(JoinPoint joinPoint){
        HttpServletRequest currentRequest = HttpUtils.getCurrentRequest();
        String queryString = currentRequest.getQueryString();
        Object[] args = joinPoint.getArgs();
        if(args.length!=1) {return;}
        System.err.println(queryString);
    }
}