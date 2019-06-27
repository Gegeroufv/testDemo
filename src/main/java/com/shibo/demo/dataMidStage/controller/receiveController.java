package com.shibo.demo.dataMidStage.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/receive")
public class receiveController {
    @RequestMapping("/t/{path}")
    public void getPath(@PathVariable("path")String path, HttpServletRequest request, HttpServletResponse response) throws Exception{
        // TODO: 2019/5/20 查询数据库/匹配不匹配/转发至相应的url
        request.getRequestDispatcher("/receive/"+path).forward(request,response);
    }
    //json的值，数字/字符串/逻辑值/数组/对象/null
    /**
     * is not null/exist
     */
    @GetMapping("/t1")
    public void getT1(){
        System.out.println("Hello World Get!");
    }
    @PostMapping("/t1")
    public void getT2(){
        System.out.println("Hello World Post!");
    }
    @PutMapping("/t1")
    public void getT3(){
        System.out.println("Hello World Put!");
    }
    @DeleteMapping("/t1")
    public void getT4(){
        System.out.println("Hello World Delete!");
    }
}
