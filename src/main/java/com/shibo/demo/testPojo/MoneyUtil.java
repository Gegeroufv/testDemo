package com.shibo.demo.testPojo;
//使用数学类进行加减
import java.math.BigDecimal;

public class MoneyUtil {

    /**
     * 输入字符串金额，保留scale位小数，向上取整
     * @param money
     * @param scale
     * @return
     */
    public static String format(String money, int scale) {
        BigDecimal bigDecimal = new BigDecimal(money);
        return bigDecimal.setScale(2).toString();
    }

    public static String nullToZero(String str) {
        if (str == null || str == "") return "0";
        return str;
    }

    /**
     * 两个字符串相乘以后，保留scale位小数
     * @param str1
     * @param str2
     * @param scale
     * @return
     */
    public static String mul(String str1, String str2, int scale) {
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) return "0";
        BigDecimal a1 = new BigDecimal(str1);
        BigDecimal a2 = new BigDecimal(str2);
        BigDecimal decimal = a1.multiply(a2);
        return decimal.setScale(scale).toString();
    }

    /**
     * 两个字符串相加后，保留scale位小数
     * @param str1
     * @param str2
     * @param scale
     * @return
     */
    public static String add(String str1, String str2, int scale) {
        BigDecimal a1 = new BigDecimal(str1);
        BigDecimal a2 = new BigDecimal(str2);
        BigDecimal add = a1.add(a2);
        return add.setScale(scale).toString();

    }

    /**
     * 相除保留scale精度
     * @param str1
     * @param str2
     * @param scale
     * @return
     */
    public static String divide(String str1, String str2, int scale) {
        BigDecimal a1 = new BigDecimal(str1);
        BigDecimal a2 = new BigDecimal(str2);
        return a1.divide(a2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
