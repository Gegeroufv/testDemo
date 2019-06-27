package com.shibo.demo.jpaTest.util;

import org.apache.commons.beanutils.BeanUtils;


import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.ArrayList;
import java.util.List;

/**
 * jpa中转换对象工具类
 */
public class TupleUtils {
    /**
     * 通过tuple建立对象,主要用在jpa中
     *
     * @param tuple 待转换的元组
     * @param obj   被转换的对象
     * @param <T>   泛型方法
     * @return 被转换对象相同的对象
     */
    public static <T> T convertTupleToBean(Tuple tuple, Class<T> obj)throws Exception {
        T o = (T) obj.newInstance();
        tuple.getElements().stream().forEach(tupleElement -> {
            try {
                BeanUtils.setProperty(o, tupleElement.getAlias(), tuple.get(tupleElement));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return o;
    }

    /**
     * 通过List<tuple>建立对象，主要用在jpa获取原生sql后建立对象中
     *
     * @param tupleList 返回的list
     * @param obj       要转换的对象
     * @param <T>       泛型方法
     * @return 需要转换的对象组成的list
     */
    public static <T> List<T> convertTupleToBean(List<Tuple> tupleList, Class<T> obj) {
        ArrayList<T> objs = new ArrayList<>();
        tupleList.stream().forEach(tuple -> {
            try {
                T o = (T) obj.newInstance();
                for (TupleElement ele : tuple.getElements()) {
                    BeanUtils.setProperty(o, ele.getAlias(), tuple.get(ele));
                }
                objs.add(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return objs;
    }
}
