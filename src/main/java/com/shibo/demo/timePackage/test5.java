package com.shibo.demo.timePackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class test5 {
    public static void main(String[] args) {
        //可以理解为线程安全的simpleDateFormat
        DateTimeFormatter dtf=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dtf);
        System.out.println(dtf.format(LocalDateTime.now()));
        dtf=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(dtf.format(LocalDateTime.now()));
        dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(dtf.parse("2019/05/01").getClass());
        System.out.println(dtf.parse("2010/01/01").get(ChronoField.YEAR_OF_ERA));
        System.out.println(dtf.getDecimalStyle());
        System.out.println(dtf.getLocale());
        //获取了那些对象
        System.out.println(dtf.getResolverFields());
    }
}
