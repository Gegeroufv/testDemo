package com.shibo.demo.utilsTest.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        Person p=new Person();
        PropertyUtilsBean propertyUtilsBean=new PropertyUtilsBean();
        PropertyDescriptor[] propertyDescriptors = propertyUtilsBean.getPropertyDescriptors(p);
        try {
            Arrays.asList(propertyDescriptors).stream().forEach(propertyDescriptor -> {
                try {
                    System.out.println(propertyDescriptor.getName() + " " + propertyUtilsBean.getNestedProperty(p, propertyDescriptor.getName()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            System.out.println();
            for(PropertyDescriptor ele:propertyDescriptors){
                System.out.println(ele);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
