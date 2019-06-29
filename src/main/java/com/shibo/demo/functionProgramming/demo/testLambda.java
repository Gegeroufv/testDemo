package com.shibo.demo.functionProgramming.demo;

import com.google.common.cache.RemovalListener;
import io.lettuce.core.masterslave.TopologyProvider;
import org.checkerframework.checker.units.qual.K;

import java.util.ArrayList;
import java.util.function.IntConsumer;

public class testLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello lambda!");
        //通过ctrl+v反向生成的
        IntConsumer kvRemovalListener = e -> System.out.println(e);
        //通过ctrl+v反向生成
        TopologyProvider topologyProvider = () -> new ArrayList();
    }
}
