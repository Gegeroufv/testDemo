package com.shibo.demo.functionProgramming.demo;

import com.google.common.base.Function;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Example3 {
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

    @NoArgsConstructor
    @Data
    @RequiredArgsConstructor(staticName = "dick")
    private static class Hello {
        @NonNull
        private String name;
        @NonNull
        private Integer age;
        private Integer randomInt = new Random().nextInt();
    }

    //属性全部是final还有代码
    @Value
    private static class testValue {
        private String name;
        private String value;
    }

    public static void main(String[] args) {
        Random seed = new Random();
        Supplier<Integer> randomInt = seed::nextInt;
        Stream.generate(randomInt).limit(100).filter(e -> e > 10).forEach(e -> System.out.println(e));

        System.out.println(new Hello("sucker", 200));
        System.out.println(Hello.dick("bbc", 201));
        testValue testValue = new testValue("sucker", "dick");
        System.out.println(testValue.name + " " + testValue.value);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //生成对象
        Supplier<Hello> randomHello = Hello::new;
        Stream.generate(randomHello).limit(10).forEach(e -> System.out.println(e));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //构造函数式链式条件
        Predicate<Integer> flag = x -> x > 5;
        //测试和取反
        System.out.println(flag.test(2) + "  " + flag.negate());

        //普通使用
        Consumer<Integer> consumer = x -> System.out.println("accept1: " + x);
        consumer.accept(1);
        Consumer<Integer> consumer2 = x -> System.out.println("accept2: " + x);
        consumer.andThen(consumer2).accept(2);


    }
}
