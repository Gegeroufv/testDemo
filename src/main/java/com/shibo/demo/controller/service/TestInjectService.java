package com.shibo.demo.controller.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;

@Service
public class TestInjectService {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    DispatcherServlet dispatcherServlet;

    public void print(Object obj, HttpServletRequest request) {
        try {
            System.out.println(mapper.writeValueAsString(obj));
            System.out.println(mapper.getFactory());
            System.out.println(mapper.getDateFormat());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        dispatcherServlet.getHandlerMappings().stream().forEach(e -> {
            try {
                e.getHandler(request);
            }catch (Exception f){
                f.printStackTrace();
            }
        });
    }
}
