
package com.shibo.demo.jpaTest.resultTest;
//https://blog.csdn.net/liuyunyihao/article/details/81106799
//对查询结果进行接收
//需要测试复杂对象


import com.shibo.demo.jpaTest.entity.resultName.result1;
import com.shibo.demo.utilsTest.beans.Person;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

//https://blog.csdn.net/x6582026/article/details/82774610 接收特定返回结果！
public class Test {
    public static void main(String[] args) {
        int i = 300;
        int j = 300;
        System.out.println(i == j ? "true" : "false");
        result1 result1 = null;
        try {
            result1 = result1.class.newInstance();
            result1 r1 = new result1();
            com.shibo.demo.jpaTest.entity.resultName.result1 result11 = r1.getClass().newInstance();
            System.out.println(result11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result1);

        HashMap<String, Object> map = new HashMap<>();
        System.out.println(map.keySet().contains("s"));

        //类型安全，测试完毕!
        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(22);
                add(22);
                add(23);
                add(159);
                add(12);
            }
        };
        System.out.println(list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())));
        boolean b = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).values().stream().allMatch(e -> e == 1 ? true : false);
        System.out.println(b);



    }


}


//https://blog.csdn.net/jdd92/article/details/81533353 批量更新

//https://blog.csdn.net/dm_vincent/article/details/53366934 解决懒加载

//https://www.cnblogs.com/zhanghongqiang/p/4113107.html 明明查询查询结果 联合查询

//https://www.jianshu.com/p/8422d4d1e764 简单的封装玩法

//https://blog.csdn.net/ditto_zhou/article/details/80830970 映射结果集

//https://blog.csdn.net/isyoungboy/article/details/87878685 jpa结果转换

//https://blog.csdn.net/liuyunyihao/article/details/81986172 jpa中使用函数