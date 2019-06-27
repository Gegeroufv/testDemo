package com.shibo.demo.functionProgramming.valida;

import java.util.ArrayList;

public class testFilter {
    private static ArrayList<Integer> data=new ArrayList(){{
        add(1);
        add(2);
        add(3);
    }};

    public static void main(String[] args) {
        data.stream().filter(e->e>=2).forEach(e-> System.out.println(e));
    }
}
