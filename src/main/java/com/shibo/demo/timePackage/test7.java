package com.shibo.demo.timePackage;

import java.time.Period;

public class test7 {
    public static void main(String[] args) {
        Period period=Period.of(1,1,1);
        System.out.println(period);
        Period period1=Period.ZERO;
        System.out.println(period1);
        Period period2=Period.from(period1);
        System.out.println(period2);
        //为了方便相加减
        System.out.println(period.negated());
    }
}
