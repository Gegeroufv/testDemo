package com.shibo.demo.utilsTest.beans;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class test3 {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Person{
        private String name;
        private Integer age;
        private List<Job> jobs;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Job{
        private String jobName;
        private Integer rank;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class TPerson{
        private String name;
        private Integer age;
    }
    //说明同类型复制会复制嵌套类型！
    public static void main(String[] args) {
        Person person = new Person("hello1", 2, new ArrayList() {{
            add(new Job("whore", 1));
            add(new Job("sucker",2));
        }});
        Person depPerson = new Person();
        BeanUtils.copyProperties(person,depPerson);
        //说明同类型复制会复制嵌套类型！
        //test3.Person(name=hello1, age=2, jobs=[test3.Job(jobName=whore, rank=1), test3.Job(jobName=sucker, rank=2)])
        System.out.println(depPerson);
        TPerson tPerson=new TPerson();
        //        TPerson tPerson=new TPerson();
        //同类型！
        BeanUtils.copyProperties(person,tPerson);
        System.out.println(tPerson);
    }
}
