package com.shibo.demo.timePackage;

import org.springframework.web.bind.annotation.CookieValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class test3 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.MIN);
        System.out.println(LocalDateTime.now());
        LocalDateTime localDateTime=LocalDateTime.now();
        //从相似方法中获取方法
        System.out.println(LocalDateTime.from(LocalDateTime.MAX));
        System.out.println(localDateTime);
        //本地时间加偏移量 OffsetDateTime转化为这样的日期类型
        System.out.println(localDateTime.atOffset(ZoneOffset.ofHours(18)).getClass());
        //截短了的日期
        System.out.println(localDateTime.truncatedTo(ChronoUnit.DAYS));
        //获取时间区间的有效值
        System.out.println(localDateTime.range(ChronoField.EPOCH_DAY));
        //获取现在使用的时间系统值
        System.out.println(localDateTime.getChronology());
    }
}
