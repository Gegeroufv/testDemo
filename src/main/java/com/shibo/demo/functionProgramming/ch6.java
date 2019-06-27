package com.shibo.demo.functionProgramming;

import java.util.Map;
import java.util.stream.IntStream;

public class ch6 {
    public static void main(String[] args) {
        Integer count = IntStream.range(1, 100).parallel().reduce(((left, right) -> {
            System.out.println(left + right);
            System.out.println(Thread.currentThread().getName());
            return left + right;
        })).getAsInt();
        System.out.println(count);
        int i = Integer.parseInt("1");
        Map<String, String> getenv = System.getenv();
        getenv.keySet().stream().forEach(e->{
            System.out.println(e+"   "+getenv.get(e));
        });
        
    }
}
