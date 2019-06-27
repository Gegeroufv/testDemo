package com.shibo.demo.testPojo;

import com.alibaba.druid.support.json.JSONUtils;
import com.shibo.demo.functionProgramming.ch2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

public class beansTest {
    private static ArrayList<Person> source = new ArrayList() {{
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

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class tPerson {
        private String name;
        private Integer age;
        private char sex;
    }

    public static void main(String[] args) {
        ArrayList<tPerson> target=new ArrayList<>();
        //通过json复制数据结构对象
        //target = JSON.parseArray(JSON.toJSONString(source), People.class);
        t2 t2 = new t2();
        t2.setId(123L);
        t1 t1 = new t1();
        BeanUtils.copyProperties(t2,t1);
        System.out.println(t1);

        System.out.println(source.stream().count());

        ArrayList arr=null;
        System.out.println(arr.stream().count());
    }


    @Data
    private static class t1{
        private String id;
    }

    @Data
    private static class t2{
        private Long id;
    }
}
