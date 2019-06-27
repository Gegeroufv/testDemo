package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class EasyPoiUtil {
    public static String[] getHeaders(Class clazz1){
        ArrayList<String> arr=new ArrayList<>();
        Field[] fields=clazz1.getDeclaredFields();
        for(Field f:fields){
            if(f.isAnnotationPresent(Excel.class)){
                arr.add(f.getAnnotation(Excel.class).name());
            }
        }
        return arr.toArray(new String[0]);
    }
}