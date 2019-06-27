package com.shibo.demo.utilsTest;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        String start = "4101163722010001";
        String end = "4101163722015000";
        BigInteger startInt = new BigInteger(start);
        BigInteger endInt = new BigInteger(end);
        System.out.println(start.getClass());
        System.out.println(start);
        System.out.println(startInt.add(new BigInteger("10")));
        startInt=startInt.add(new BigInteger("10"));
        while (startInt.compareTo(endInt) < 1) {
            System.out.println(startInt);
            startInt = startInt.add(new BigInteger("10"));
        }

    }
}
