package com.shibo.demo.timePackage;

import java.time.*;
import java.util.Date;

public class test4 {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        LocalTime localTime=LocalTime.now();
        //从相似的类型中提取
        System.out.println(LocalTime.from(LocalDateTime.now()));
        //最大最小值
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIDNIGHT);
        //指定时区来源
        System.out.println(LocalTime.now(Clock.systemDefaultZone()));
        //instant到localDateTime的指定转换方式
        System.out.println(LocalTime.now(ZoneId.systemDefault()));
        System.out.println(LocalTime.of(10,20));
        //获取十二点
        System.out.println(LocalTime.NOON);
        //转变时间为offset
        System.out.println(localTime.atOffset(ZoneOffset.ofHours(1)));
        //给其添加时间
        System.out.println(localTime.atDate(LocalDate.now()));
        //现在所处的纳秒
        System.out.println(localTime.toNanoOfDay());
    }
}
