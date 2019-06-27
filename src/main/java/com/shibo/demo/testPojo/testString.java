package com.shibo.demo.testPojo;

public class testString {
    public static void main(String[] args) {
        String str1="123456";
        String substring1 = str1.substring(str1.length() -2, str1.length() );
        String substring2 = str1.substring(0, str1.length() - 2);
        System.out.println(substring1);
        System.out.println(substring2);
        System.out.println(substring1+"."+substring2);
    }
}
