package com.shibo.demo.functionProgramming.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Example2 {
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
        list.stream().flatMap(e -> e.getProperties().stream()).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
        Optional<Person> any = list.stream().findAny();
        System.out.println(any.get());
        //流转换为迭代器
        Iterator<Person> iterator = list.stream().iterator();
        iterator.forEachRemaining(e->{
            System.out.println(e);
        });
        //对并行的流进行顺序处理
        list.parallelStream().forEachOrdered(e-> System.out.println(e));
        list.stream().forEach(e-> System.out.println(e));
        String collect = list.stream().map(e -> e.name).collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect);

        list.forEach((ve)->{
            System.err.println(ve);
        });

    }
}
