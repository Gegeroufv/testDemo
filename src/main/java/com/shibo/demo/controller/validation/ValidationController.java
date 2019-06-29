package com.shibo.demo.controller.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//嵌套对象上需要加入@Valid
@RestController
@RequestMapping("/vali")
public class ValidationController {
    @PostMapping("/t1")
    public void t1(@RequestBody @Validated NestingObject obj){
        System.out.println(obj);
    }

    //不能直接用数组接收对象，否则验证框架不生效！
    @PostMapping("/t2")
    public void t2(@RequestBody @Validated List<NestingObject2> obj){
        System.out.println(obj);
    }

    //多层嵌套可以成功！
    @PostMapping("/t3")
    public void t3(@RequestBody @Validated NestingObject3 obj){
        System.out.println(obj);
    }
}
