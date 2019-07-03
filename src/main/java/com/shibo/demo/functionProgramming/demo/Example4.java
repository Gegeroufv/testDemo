package com.shibo.demo.functionProgramming.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Example4 {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Person {
        private String name;
        private Integer age;
        private Character sex;
        private ArrayList<String> properties = new ArrayList<>();
    }

    static final ArrayList<Person> list = new ArrayList() {{
        add(new Person("p1p", 12, 'm', new ArrayList() {{
            add("car");
            add("house");
            add("pet");
        }}));
        add(new Person("p2er", 23, 'f', new ArrayList() {{
            add("benz");
            add("wanke");
            add("cat");
        }}));
        add(new Person("p3rtt", 34, 'm', new ArrayList() {{
            add("bmw");
            add("biguiyuan");
            add("dog");
            add("farm");
            add("cat");
        }}));
        add(new Person("p4gets", 45, 'f', new ArrayList() {{
            add("haff");
            add("rongchuang");
            add("fox");
        }}));
    }};

    static final HashSet<String> hs = new HashSet() {{
        add("aadf");
        add("bddsf");
        add("ccsdf");
        add("1123");
    }};

    static final ArrayList<LocalDateTime> times = new ArrayList() {{
        add(LocalDateTime.of(1, 2, 3, 4, 5, 6, 7));
        add(LocalDateTime.of(2, 2, 3, 4, 5, 6, 7));
        add(LocalDateTime.of(3, 2, 3, 4, 5, 6, 7));
    }};

    public static void main(String[] args) {
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //带参数的遍历
        IntStream.range(0,list.size()).forEach(e-> System.out.println(list.get(e)));
        System.out.println();
        //peek没有返回值，是对元素的操作,是一个中间操作！
        list.stream().peek(e->{
            if (e.age==12){
                System.err.println(e);
            }
        }).forEach(e->{
            if(e.age!=12){
                System.out.println(e);
            }
        });

    }
}
