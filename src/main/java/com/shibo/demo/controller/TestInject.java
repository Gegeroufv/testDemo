package com.shibo.demo.controller;


import com.shibo.demo.controller.service.TestInjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/inject")
public class TestInject {
    @Autowired
    private TestInjectService testInjectService;
    @PostMapping("/print")
    public void printObject(@RequestBody Object obj,HttpServletRequest request){
        System.out.println(obj);
        System.out.println(obj.getClass().getFields());
        this.testInjectService.print(obj, request);
    }
}
