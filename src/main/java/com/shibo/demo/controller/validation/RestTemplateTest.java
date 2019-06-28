package com.shibo.demo.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RequestMapping("/to1")
@RestController
public class RestTemplateTest {
    @Value("${server.port}")
    private String port;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/t1")
    public void t1(){
        NestingObject nestingObject = new NestingObject("test", 1, new ArrayList() {{
            add(new NestingObject2("hello1"));
            add(new NestingObject2("hello2"));
        }});
        NestingObject nestingObject2 = new NestingObject("test", 1, new ArrayList() {{
            add(new NestingObject2("hello1"));
            add(new NestingObject2());
        }});
        System.out.println(port);
        restTemplate.postForEntity("http://localhost:"+port+"/vali/t1",nestingObject,null);
        restTemplate.postForEntity("http://localhost:"+port+"/vali/t1",nestingObject2,null);
    }
}
