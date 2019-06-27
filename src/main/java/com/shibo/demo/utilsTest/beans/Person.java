package com.shibo.demo.utilsTest.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Person{
    private String name="sucker";
    private Integer age=11;
    private String des;
    private LocalDateTime date= LocalDateTime.now();

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getDes() {
//        return des;
//    }
//
//    public void setDes(String des) {
//        this.des = des;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
}