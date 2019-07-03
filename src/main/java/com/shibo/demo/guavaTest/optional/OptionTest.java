package com.shibo.demo.guavaTest.optional;

import com.google.common.base.Optional;
import com.shibo.demo.functionProgramming.demo.Example2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class OptionTest {
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
        Optional<Person> op=null;
//        System.out.println(op.);
        op=Optional.of(list.get(0));
        System.out.println();
    }
}
