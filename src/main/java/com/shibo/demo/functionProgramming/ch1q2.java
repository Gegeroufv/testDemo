package com.shibo.demo.functionProgramming;

import javax.swing.text.DateFormatter;

/**
 * java8使用lambda来保存当前线程里局部变量的值
 */
public class ch1q2 {
    public static void main(String[] args) {
        ThreadLocal<DateFormatter> tl=ThreadLocal.withInitial(()->new DateFormatter());
        Thread t1=new Thread(()->{
                    System.out.println("test1");
            System.out.println(tl.get().toString());
        });
        Thread t2=new Thread(()->{
                System.out.println("test2");
        });
        t1.start();
        t2.start();
    }
}
