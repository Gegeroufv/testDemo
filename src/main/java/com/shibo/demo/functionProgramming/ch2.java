package com.shibo.demo.functionProgramming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class ch2 {
    private static ArrayList<String> arr = new ArrayList() {{
        add("a1");
        add("b2");
        add("c3");
        add("d4");
        add("e5");
    }};

    static {
        System.out.println("hello world 2019/5/15");
        String word = "hello";
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.charAt(i));
        }
        for (String ele : asList("hello", "world", "!")) {
            System.out.println(ele);
        }
        Stream.of("hello1", "world", "!").map(e -> {
            return e.toUpperCase();
        }).forEach(e -> System.out.println(e));
    }

    private static ArrayList<Person> personList = new ArrayList() {{
        add(new Person("p1", 11, 'm'));
        add(new Person("p2", 22, 'f'));
        add(new Person("p3", 33, 'm'));
        add(new Person("p4", 44, 'f'));
    }};

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Person {
        private String name;
        private Integer age;
        private char sex;
    }

    public static void main(String[] args) {
        arr.stream().forEach(e -> System.out.println(e));
        personList.stream().filter(e -> {
            System.out.println(e);
            return e.age >= 33 ? true : false;
        });//惰性求值，返回值是stream就是惰性求值
        personList.stream().filter(e -> {
            return e.age >= 33 ? true : false;
        }).forEach(e -> System.out.println(e));//返回值是空或者另一个值不是惰性求值
        //这种设计类似于构建者模式，在调用build方法之前，只对细节进行规定
        List<Person> list = personList.stream().collect(Collectors.toList());//回收
        personList.stream().map(e -> {
            return e.age;
        }).forEach(e -> System.out.println(e));//转换

        List<Integer> temp = Stream.of(asList(1, 2), asList(3, 4)).flatMap(e -> e.stream()).collect(Collectors.toList());
        temp.stream().forEach(e -> System.out.println(e));//展开多个数据结构
        int max = temp.stream().max(Comparator.comparing(e -> e.intValue())).get();//这里的Comparator应该多学一下
        System.out.println("max=" + max);

        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);//从零开始
        System.out.println("reduce=" + count);
        BinaryOperator<Integer> accumulator = (acc, elemnt) -> acc + elemnt;
        int count2 = accumulator.apply(accumulator.apply(0, 1), 2);//reduce的展开操作
    }
}
