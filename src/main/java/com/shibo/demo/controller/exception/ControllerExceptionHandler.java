package com.shibo.demo.controller.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import io.swagger.annotations.ResponseHeader;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RegExUtils;
import org.checkerframework.checker.regex.RegexUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//传入的json设置默认值!!!
@RestControllerAdvice
public class ControllerExceptionHandler {
    @Autowired
    ObjectMapper mapper;
    private static Pattern uniqueR=Pattern.compile("'(?!UK_).+?'");

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMsg handlerConstraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        System.out.println(e.getConstraintName() + "  " + e.getLocalizedMessage() + " 1");
        System.out.println(e.getSQLException() + " 2");
        //通过拿到问题的原因，然后获取相关信息
        System.out.println(e.getCause() + " 3");
        Matcher matcher = uniqueR.matcher(e.getCause().toString());
        int i = matcher.groupCount();

        System.out.println(e.getStackTrace() + " 4");
        System.out.println(e.getSQL() + " 5");
        System.out.println();
        //https://blog.csdn.net/m0_37681532/article/details/80185791 通过获取body里面的对象然后获取相应的对象名
        //获取接收者对象然后通过反序列化获取信息
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL.toString());
        request.getQueryString();
        try {
            //流已经关闭，只能读取一次getInputStream() has already been called for this request
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            //注意流一般只能读取一次便会自动关闭，java本身的机制
//            IOUtils.buffer(reader).lines().forEach(line -> {
//                System.out.println(line);
//                sb.append(line);
//            });
            System.out.println(sb.toString());
            JsonNode jsonNode = mapper.readTree(reader);
            jsonNode.fieldNames().forEachRemaining(v-> System.out.println(v));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return new ExceptionMsg();

    }
}
