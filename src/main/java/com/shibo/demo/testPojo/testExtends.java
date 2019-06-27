package com.shibo.demo.testPojo;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testExtends {
    @Data
    private static class t1{
        private String name="bbc";
    }
    @Data
    private static class t2 extends t1{
        private String name="blonde";
    }
    @ToString
    @Builder
    public static class t3{
        private String name;
        private Integer age;
        private LocalDateTime createTime;

    }
    @Data
    @Builder
    public static class t4{
        private String name;
        private Integer age;
        @Singular
        private Map<String,String> names;
    }

    public static void main(String[] args) {
        System.out.println(new t1());
        System.out.println(new t2());
        t3 build = t3.builder().name("hello world!").age(20).createTime(LocalDateTime.now()).build();
        System.out.println(build);
        System.out.println(t3.builder().age(11));
        t4 test4= t4.builder().name("hello singular!").age(100).name("bbc","blonde").name("asian","black").build();
        System.out.println(test4);
        t4 test5= t4.builder().build();
        BeanUtils.copyProperties(test4,test5);
        //推荐使用构建者模式！！！
        System.out.println(test5);
    }
}

