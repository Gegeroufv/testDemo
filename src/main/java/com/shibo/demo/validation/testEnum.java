package com.shibo.demo.validation;

public class testEnum {
    public static void main(String[] args) {
        boolean flag=BankNames.isLegal("兴业银行郑州商务外环路支行 ".trim());
        System.out.println(flag);

    }
}
