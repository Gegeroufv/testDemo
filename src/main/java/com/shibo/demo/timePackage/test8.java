package com.shibo.demo.timePackage;

import java.time.temporal.ChronoUnit;

public class test8 {
    public static void main(String[] args) {
        System.out.println(ChronoUnit.values());
        ChronoUnit chronoUnit=ChronoUnit.DAYS;
        System.out.println(chronoUnit.isDateBased());
        for(ChronoUnit c:ChronoUnit.values()){
            System.out.println(c+" "+c.getDuration());
        }
        System.out.println(chronoUnit.isDurationEstimated());
    }
}
