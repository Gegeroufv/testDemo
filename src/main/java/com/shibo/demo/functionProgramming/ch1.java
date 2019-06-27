package com.shibo.demo.functionProgramming;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public class ch1 {
    public static void main(String[] args) {
        o2 to2=new o2();
        BeanUtils.copyProperties(new o1("t1",22,"leak"),to2);
        System.out.println(to2);
    }
    @AllArgsConstructor
    @Data
    private static class o1{
        private String name;
        private int age;
        private String p1;
    }
    @Data
    private static class o2{
        private String name;
        private int age;
        private String p2;
    }
}
