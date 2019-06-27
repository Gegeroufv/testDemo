package com.shibo.demo.utilsTest.udu;

import com.shibo.demo.utilsTest.beans.Person;
import org.apache.commons.beanutils.PropertyUtilsBean;

import javax.validation.constraints.NotNull;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//对对象的判断
public class BeansPropertiesValid {
    private static class ValidUtil {
        /**
         * @param clazz 需要被验证的对象
         * @param flag 验证是否为空
         * @param properties 需要被验证的参数项
         * @return
         */
        //System.out.println(propertyDescriptor.getName() + " " + propertyUtilsBean.getNestedProperty(p, propertyDescriptor.getName()));
        private static PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        private static Set<String> pros = null;

        public static Boolean isPropertiesLegal(Object obj, Boolean flag, @NotNull String... properties) {
            PropertyDescriptor[] propertyDescriptors = propertyUtilsBean.getPropertyDescriptors(obj.getClass());
            pros = new HashSet<>(Arrays.asList(properties));

            return Arrays.asList(propertyDescriptors).stream().allMatch(propertyDescriptor -> {
                if (pros.contains(propertyDescriptor.getName())) {
                    try {
                        if (Objects.isNull(propertyUtilsBean.getNestedProperty(obj, propertyDescriptor.getName())) == flag) {
                            return true;
                        } else {
                            return false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            });
        }

        public static void main(String[] args) {
            Person p = new Person();
            System.out.println(isPropertiesLegal(p, false, new String[]{"name","age","des"}));
        }
    }
}
