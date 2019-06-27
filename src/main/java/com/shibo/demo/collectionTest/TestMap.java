package com.shibo.demo.collectionTest;

import java.util.LinkedHashMap;

public class TestMap {
    private static LinkedHashMap<Integer,String> data=new LinkedHashMap(){{
        put(1,"h");
        put(2,"e");
        put(3,"l");
        put(4,"l");
        put(5,"o");
    }};
    public static void main(String[] args) {
        System.out.println(data.containsKey(1));

    }
}
