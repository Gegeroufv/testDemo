package com.shibo.demo.utilsTest.beans;

import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;


public class test1 {
    @ToString
    @Builder
    private static class Person {
        private String name;
        private Integer age;
        private Character gender;
    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Dick extends PropertyEditorManager {
        private double howLong;
        private String color;
        private String name;

        public String fuck(String name) {
            return new String("fuck the girl-name: " + name);
        }

        public String fuck() {
            return new String("Mastribation");
        }
    }

    public static void main(String[] args) {
        Person person = Person.builder().name("hello").age(11).gender('m').build();
        System.out.println(person);

        Dick dick = new Dick(20.1, "black", "BBC");
        Method getName = BeanUtils.findDeclaredMethod(Dick.class, "getName");
        System.out.println(getName);
        System.out.println("name: " + getName.getName() + " defaultValue: " + getName.getDefaultValue() + " ReturnType: " + getName.getReturnType());
        //找到声明的最少参数的方法
        Method fuck = BeanUtils.findDeclaredMethodWithMinimalParameters(Dick.class, "fuck");
        //没搞明白，这个是属性编辑器用来获取属性信息
        PropertyEditor editorByConvention = BeanUtils.findEditorByConvention(Dick.class);
        //获取构造器
        Dick instantiateDick = BeanUtils.instantiateClass(Dick.class);
        System.out.println("=======================================");
        System.out.println("instantiateDick : " + instantiateDick);
        instantiateDick.setColor("yello");
        instantiateDick.setHowLong(16);
        instantiateDick.setName("Chinese_dick");
        System.out.println("instantiateDick : " + instantiateDick);

        //属性名称
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(Dick.class);
        Arrays.asList(propertyDescriptors).stream().forEach(e -> System.out.println(e));
        Arrays.asList(propertyDescriptors).stream().forEach(e -> System.out.println(e.getName()));
        System.out.println("=======================================");
        //通过方法查找属性
        Method getColor = BeanUtils.findDeclaredMethodWithMinimalParameters(Dick.class, "getColor");
        PropertyDescriptor propertyForMethod = BeanUtils.findPropertyForMethod(getColor);
        System.out.println(propertyForMethod);
        System.out.println("=======================================");
        PropertyDescriptor name = BeanUtils.getPropertyDescriptor(Dick.class, "name");
        MethodParameter writeMethodParameter = BeanUtils.getWriteMethodParameter(name);
        System.out.println(writeMethodParameter);
        System.out.println(writeMethodParameter.getParameter());
        System.out.println(writeMethodParameter.getParameterIndex());
        System.out.println("=======================================");
        String isNullConvention = editorByConvention == null ? "Null" : "NotNull";
        System.out.println("isNullConvention: " + isNullConvention);
        try {
            System.out.println("=======================================");
            System.out.println(getName.invoke(dick));
            System.out.println(fuck.invoke(dick));
        } catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
