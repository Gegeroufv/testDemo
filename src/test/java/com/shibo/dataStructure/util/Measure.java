package com.shibo.dataStructure.util;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Measure {
    @FunctionalInterface
    public interface measureInterface{
        void execute();
    }
    public static void measuring(measureInterface measureInterface,String methodname){
        long now=System.currentTimeMillis();
        measureInterface.execute();
        long end=System.currentTimeMillis();
        System.out.println("methodName : "+methodname+"  Duration : "+(end-now));
    }
}
