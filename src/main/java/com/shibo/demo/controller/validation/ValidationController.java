package com.shibo.demo.controller.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//嵌套对象上的表单注解没有用！
@RestController
@RequestMapping("/vali")
public class ValidationController {
    @PostMapping("/t1")
    public void t1(@RequestBody @Validated NestingObject obj){
        System.out.println(obj);
    }
}
