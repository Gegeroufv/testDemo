package com.shibo.demo.utilsTest;

import com.shibo.demo.excel.test1;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

public class JpqlUtils {
    public static void main(String[] args) {
        test1 t1 = new test1("1", new Date(), "serialNum", "bank", "pay", "amount", "recharge");
        HashSet<String> excludeCondition = new HashSet<>();
        excludeCondition.add("serialNumber");
        HashMap<String, Object> jpql = getJpql(t1, excludeCondition);
        System.out.println(jpql.get("jpql"));
        System.out.println(jpql.get("params"));
        System.out.println(jpql.get("params").getClass());
        String str = "com.shibo.demo.excel.test1";
        int i = str.lastIndexOf(".");
        System.out.println(str.substring(i + 1, str.length()));

    }

    //拼接Jpql: from machine where id is not null
    public static HashMap<String, Object> getJpql(Object o, Set<String> excludeCondition) {
        //o.getClass().getName()
        StringBuilder sb = new StringBuilder().append("from " + o.getClass().getName().substring(o.getClass().getName().lastIndexOf(".") + 1, o.getClass().getName().length()) + " where id is not null");
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> result = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                //and channelId = :channelId
                if (!excludeCondition.contains(f.getName())) {
                    if (f.get(o) != null && StringUtils.hasText(f.get(o).toString())) {
                        sb.append(" and " + f.getName() + " = :" + f.getName());
                        params.put(f.getName(), f.get(o));
                    }
                }
            }
            result.put("params", params);
            result.put("jpql", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
