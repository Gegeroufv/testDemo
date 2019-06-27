package com.shibo.demo.testPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrr=new ArrayList(){{
            add(1);
            add(2);
            add(3);
        }};
        ArrayList<Integer> arrr2=new ArrayList(){{
            add(1);
            add(3);
        }};
        List<Integer> collect = arrr.stream().filter(e -> {
            return !arrr2.contains(e.intValue());
        }).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(Integer.valueOf(MoneyUtil.mul("100", "100", 0)));
        System.out.println(MoneyUtil.add("100","0",2));

        System.out.println();
    }
}
