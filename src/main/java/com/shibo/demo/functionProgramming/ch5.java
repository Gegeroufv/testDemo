package com.shibo.demo.functionProgramming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class ch5 {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class person {
        private String name;
        private Integer age;
        private Character sex;
        private ArrayList<String> properties;
    }

    static final ArrayList<person> list = new ArrayList() {{
        add(new person("p1p", 12, 'm', new ArrayList() {{
            add("car");
            add("house");
            add("pet");
        }}));
        add(new person("p2er", 23, 'f', new ArrayList() {{
            add("benz");
            add("wanke");
            add("cat");
        }}));
        add(new person("p3rtt", 34, 'm', new ArrayList() {{
            add("bmw");
            add("biguiyuan");
            add("dog");
            add("farm");
        }}));
        add(new person("p4gets", 45, 'f', new ArrayList() {{
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

    public static void main(String[] args) {
        //这里说明flatmap只展开集合
        System.out.println(list);
        List<String> clist = list.stream().map(e -> e.properties).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(clist);
        List<String> clist2 = list.stream().flatMap(e -> e.getProperties().stream()).collect(Collectors.toList());
        System.out.println(clist2);
        list.stream().map(person::hashCode).forEach(e -> System.out.println(e));
        List<String> hslist = hs.stream().collect(Collectors.toList());
        System.out.println(hslist);
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(Collectors.summarizingInt(e -> e.getProperties().size()));
        System.out.println(intSummaryStatistics);
        //分组器,真心爽！！！
        Map<Boolean, List<person>> booleanListMap = list.stream().collect(Collectors.partitioningBy(e -> e.age > 22));
        System.out.println(booleanListMap);
        //数据分组
        Map<Integer, List<person>> integerListMap = list.stream().collect(Collectors.groupingBy(e -> e.getProperties().size()));
        System.out.println(integerListMap);
        //字符串处理joining收集流中的值
        String names = list.stream().map(person::getName).collect(Collectors.joining(" ", "[", "]"));
        System.out.println(names);
        //使用多个收集器,下游收集器，允许对某些集合进行操作
        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(e -> e.getName().length(), Collectors.mapping(e -> e.getAge(), Collectors.toList())));
        System.out.println(map);

        System.out.println();
        double sum = list.stream().mapToDouble(e -> e.getAge()).sum();
        System.out.println(sum);

        System.out.println();
        List<String> collect = list.stream().flatMap(e -> e.getProperties().stream()).collect(Collectors.toList());
        System.out.println(collect);

    }
}
