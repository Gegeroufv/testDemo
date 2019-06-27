package com.shibo.demo.excel;

import java.lang.reflect.Field;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        test1 t1=new test1("1",new Date(),"serialNum","bank","pay","amount","recharge");
//        test1 t1=new test1();
        Field[] fields=t1.getClass().getDeclaredFields();
        try {
            int i=0;
            for (Field f : fields) {
                f.setAccessible(true);
                System.out.println(f.getName()+"    "+f.get(t1));
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
