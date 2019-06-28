package com.shibo.demo.functionProgramming.demo;

import io.lettuce.core.masterslave.TopologyProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Example1 {
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
        //parallel方法搞出来的比较乱，需要先收集再搞
        list.parallelStream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(e -> {
            System.out.println(e);
        });
        System.out.println("=====================");
        //并行变串行，这个一定要注意这个技巧！！！
        list.parallelStream().sequential().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(e -> {
            System.out.println(e);
        });
        System.out.println("=====================");
        int sumAge = list.parallelStream().mapToInt(Person::getAge).reduce((a, b) -> a + b).getAsInt();
        System.out.println(sumAge);
        //可能出现ArrayIndexOutOfBoundsException 线程不安全的问题，最好是直接给搞个初始量！
        Person reducePerson = list.parallelStream().reduce(new Person("fuck", 100, 'g', new ArrayList(10000) {{
            add("dick");
            add("sucker");
            add("sluty");
        }}), (p, p1) -> {
            p.getProperties().addAll(p1.getProperties());
            return p;
        });
        System.out.println(reducePerson);
        System.out.println("=====================");
        //这里在一定的情况下可能会出异常！
        //最后一个参数进行并行处理！！！最后一个收集器对并行代码进行收集
        list.parallelStream().reduce(new Person(), (a, b) -> {
            a.getProperties().addAll(b.getProperties());
            return a;
        }, (a, b) -> {
            a.getProperties().addAll(b.getProperties());
            return a;
        });
        //开启并行的时间普通可能会出现性能问题！！！

        System.out.println("=====================");
        Optional<LocalDateTime> first = times.stream().sorted((a, b) -> a.isAfter(b) ? -1 : 1).findFirst();
        System.out.println(first);
        //https://blog.csdn.net/icarusliu/article/details/79504602 这里还要注意看注释
        System.out.println("=====================");
        //java版仿照scala的wordCount
        list.parallelStream().flatMap(e -> e.getProperties().stream()).sorted().collect(() -> new ArrayList<>(), List::add, List::addAll)
                .stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).forEach((key, value) -> System.out.println(key + "  " + value));
        TopologyProvider topologyProvider = () -> new ArrayList();
        System.out.println(topologyProvider.getNodes() + "   " + topologyProvider.getNodesAsync());
    }
}
