package com.shibo.demo.excel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class test3 {
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
        ArrayList<Person> arr = new ArrayList<>();
        arr.addAll(personList);
        for (Person p : arr) {
            if (p.getName().equals("p2")) {
                personList.remove(p);
            }
        }
        System.out.println(personList);
        arr.stream().forEach(e -> e.setAge(111));
        System.out.println(arr);
        IntSummaryStatistics intSummaryStatistics=personList.stream().map(e->e.getAge()).collect(Collectors.toList()).stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(intSummaryStatistics);
        personList.stream().map(e->e.getAge()).collect(Collectors.summarizingInt(Integer::intValue));
    }
}
