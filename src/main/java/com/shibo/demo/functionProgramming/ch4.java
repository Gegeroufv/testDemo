package com.shibo.demo.functionProgramming;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ch4 {
    public static void main(String[] args) {
        //为了替代一个null的方法
        Optional<String> a= Optional.of("a");
        Optional emptyOptional=Optional.empty();
        Optional alseEmpty=Optional.ofNullable(null);
        System.out.println(emptyOptional);
        System.out.println(alseEmpty);
    }
}
