package com.shibo.demo.timePackage;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class test1 {
    public static void main(String[] args) {
        Instant instant= Instant.now();
        //现在时间
        System.out.println(instant);
        //Constant for the 1970-01-01T00:00:00Z epoch instant.
        System.out.println(Instant.EPOCH);
        //This could be used by an application as a "far future" instant.
        System.out.println(Instant.MAX);
        //This is one year earlier than the minimum
        System.out.println(Instant.MIN);
        /**
         * 通过文档获知，正值和负值都是以纪元时间的先后尽心分割
         */
        System.out.println(Instant.ofEpochMilli(86400000));
        System.out.println(Instant.ofEpochSecond(86400));
        //对时间进行矫正，文档中有写
        System.out.println(Instant.ofEpochSecond(86400,100));
        //可以按照始终获取来源进行获取
        System.out.println(Instant.now(Clock.systemDefaultZone()));
        //对不同的日期进行转换，只要是实现了接口的
        System.out.println(Instant.from(ZonedDateTime.now()));
        //获取从纪元时间到现在的秒数
        System.out.println(instant.getEpochSecond());
        //获取纳秒数
        System.out.println(instant.getNano());
        //截取其中的一部分
        System.out.println(instant.get(ChronoField.NANO_OF_SECOND));
        //比较时间
        System.out.println(instant.compareTo(Instant.EPOCH));
        //调整至相同类型获取时瞬
        System.out.println(instant.adjustInto(Instant.now()));
        //形成偏移日期
        System.out.println("atOffset:"+instant.atOffset(ZoneOffset.ofHours(2)));
        //设置时区
        System.out.println(instant.atZone(ZoneId.systemDefault()));
        //截取其中的一部分
        System.out.println(instant.getLong(ChronoField.NANO_OF_SECOND));
        System.out.println(instant.isAfter(instant));
        System.out.println(instant.isBefore(instant));
        System.out.println(instant.isSupported(ChronoField.NANO_OF_SECOND));
        //时间日期相加减
        System.out.println(instant.minus(Duration.ofDays(100000)));
        System.out.println(instant.plusMillis(1000000));
        //显示日期时间段范围
        System.out.println(instant.range(ChronoField.NANO_OF_SECOND));
        //截断日期到一个值
        System.out.println(instant.truncatedTo(ChronoUnit.DAYS));
        //此时间与结束瞬间的时间量
        System.out.println(instant.until(Instant.now(),ChronoUnit.SECONDS));
    }
}
