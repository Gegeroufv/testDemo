package com.shibo.dataStructure.chapter1;

import com.shibo.dataStructure.util.Measure;

public class Test1 {
    private static double[] doubles=null;
    static {
        doubles=new double[]{
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        };
    }
    public static void main(String[] args) {
        Measure.measureInterface fun1=()->{
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            polynome1(doubles,10);
            System.out.println(polynome1(doubles,10));
        };
        Measure.measureInterface fun2=()->{
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            polynome2(doubles,10);
            System.out.println(polynome2(doubles,10));
        };
        Measure.measuring(fun1,"polynome1");
        Measure.measuring(fun2,"polynome2");
    }
    //求多项式代码
    public static double polynome1(double[] a,double x){
        double result=0;
        for(int i=0;i<a.length;i++){
            result=result+a[i]*Math.pow(x,i);
        }
        return result;
    }
    //秦九韶算法
    public static double polynome2(double[] a,double x){
        double result=0;
        double temp=0;
        for(int i=1;i<a.length;i++){
            temp=(temp+a[a.length-i])*x;
        }
        return result+temp+a[0];
    }
}
