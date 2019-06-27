package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    /**
     * 获取所有的表头
     * @param clazz1 需要处理的excel类
     * @return 所有的表头信息
     */
    public static String[] getHeaders(Class clazz1){
        ArrayList<String> arr=new ArrayList<>();
        Field[] fields=clazz1.getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true);
            if(f.isAnnotationPresent(Excel.class)){
                arr.add(f.getAnnotation(Excel.class).name());
            }
        }
        return arr.toArray(new String[0]);
    }

    /**
     * 验证excel是否合乎规则
     * @param t1 传入的excel
     * @return
     */
//    public static boolean validation(test1 t1){
//        if(isBlank(t1.getBankName())||
//                isBlank(t1.getPayAccount())||isBlank(t1.getPayName())|| isBlank(t1.getTradeNum())
//                ||isBlank(t1.getTradeDate().toString())){
//            return false;
//        }else {
//            if(t1.getAmount()>0){
//                return true;
//            }else {
//                return false;
//            }
//        }
//    }

    /**
     * 判断该字符串是否为空（排除空格）
     * @param str 字符串
     * @return
     */
    public static boolean isBlank(String str){
        if(str==null){
            return true;
        }
        if(str.trim().length()>0){
            return false;
        }else {
            return true;
        }
    }
}
