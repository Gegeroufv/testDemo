package com.shibo.demo.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tt")
public class testVOController {
    @PostMapping("/t")
    public void tt(TheVo theVo){

    }

    @PostMapping("/localdatetime")
    public void localdatetime(@RequestBody tLocalDateTime time){
        System.out.println(time);
    }
    @Data
    private static class tLocalDateTime{
        LocalDateTime time;
    }
}
