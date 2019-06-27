package com.shibo.demo.timePackage;


import java.time.*;
import java.time.chrono.IsoEra;
import java.time.chrono.MinguoDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQueries;

public class test2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getClass());
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.MIN);
        //获得特定时区的localDate
        System.out.println(LocalDate.now(ZoneOffset.UTC));
        //获取特定的时钟
        System.out.println(LocalDate.now(ZoneId.systemDefault()));
        //使用不同的历法
        System.out.println(LocalDate.from(MinguoDate.now()));
        //距离纪元时间的偏移量的值
        System.out.println(LocalDate.ofEpochDay(10000));
        System.out.println(LocalDate.of(2001, 01, 02));
        System.out.println(LocalDate.ofYearDay(2011, 100));
        //对CharSequence进行解析抓换
        System.out.println(LocalDate.parse("2019-03-05"));
        //对现有的时间类的精度以及属性信息进行查询,可以获得很多信息
        System.out.println(localDate.query(TemporalQueries.precision()));
        //获取纪元信息等
        System.out.println(localDate.get(ChronoField.ERA));
        //调整至相同类型获取时瞬，这里要求是同一类型
        System.out.println(localDate.adjustInto(LocalDate.now()));
        //1970-1-1距现在的时间
        System.out.println(localDate.getLong(ChronoField.EPOCH_DAY));
        //得到一个period对象，用以返回相对应的对象
        System.out.println(localDate.until(LocalDate.now()).getClass());
        //返回一个部分状态改变的对象
        System.out.println(localDate.with(IsoEra.BCE));
        //创建一个localDateTime
        System.out.println(localDate.atStartOfDay());
    }
}
