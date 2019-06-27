package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.lang.reflect.Field;


public class testMethod {
    public static void main(String[] args){
        Field[] fields=test1.class.getDeclaredFields();
        for(Field f:fields){
            if(f.isAnnotationPresent(Excel.class)){
                String str=f.getAnnotation(Excel.class).name();

                System.out.println(str);
            }
        }
    }
}
