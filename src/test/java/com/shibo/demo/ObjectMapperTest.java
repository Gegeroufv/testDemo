package com.shibo.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shibo.demo.functionProgramming.demo.Example1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;


@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectMapperTest {
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
    @Autowired
    ObjectMapper mapper;
    @Test
    public void test1(){
        log.info("hello");
        list.forEach(e->{
            try {
                System.out.println(mapper.writeValueAsString(e));
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        });
    }
}
