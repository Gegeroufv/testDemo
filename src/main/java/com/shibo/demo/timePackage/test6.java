package com.shibo.demo.timePackage;

import java.time.Duration;
import java.time.LocalDateTime;

public class test6 {
    public static void main(String[] args) {
        Duration duration=Duration.ofDays(100);
        System.out.println(duration.getUnits());
        duration=duration.abs();
        System.out.println(duration);
        duration=Duration.from(Duration.ZERO);
        System.out.println(duration.getClass());
        duration=Duration.ofDays(20);
        System.out.println(duration.dividedBy(100));
        //两者的差值，这里需要使用最小单位是秒
        System.out.println(Duration.between(LocalDateTime.now(),LocalDateTime.MIN));
    }
}
