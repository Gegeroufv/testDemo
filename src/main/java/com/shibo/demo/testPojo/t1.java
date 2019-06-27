package com.shibo.demo.testPojo;

public class t1 {
    public static void main(String[] args) {
        for(Color c:Color.values()){
            System.out.println(c.getName()+"==="+c.getIndex());
        }
    }
}
