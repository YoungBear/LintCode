package com.ysx.lintcode.hard;

/**
 * 54. 转换字符串到整数
 * http://www.lintcode.com/zh-cn/problem/string-to-integer-ii/
 * 需要注意Integer.MIN_VALUE和Integer.MAX_VALUE及其附近的数。
 */
public class AtoISolution {

    public static final String MAX_STR = String.valueOf(Integer.MAX_VALUE);
    public static final String MIN_STR = String.valueOf(Integer.MIN_VALUE);

    public static void main(String[] args) {
//        System.out.println(MAX_STR);
//        System.out.println(MIN_STR);
//        System.out.println(Integer.parseInt("43int"));
        AtoISolution test = new AtoISolution();
//        System.out.println(test.atoi("0.1"));
//        System.out.println(test.atoi("-1.0"));
//        System.out.println(test.atoi("10"));
//        System.out.println(test.atoi("     k"));
//        System.out.println(test.atoi("-1"));
//        System.out.println(Integer.parseInt("10"));
        System.out.println(test.atoi("   +-1111 "));
        System.out.println(test.atoi(MIN_STR));

    }

    /*
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        boolean flag = true;
        int result = 0;
        if (str == null) {
            return 0;
        }
        if (str.equals(MIN_STR)) {
            return Integer.MIN_VALUE;
        }
        /**
         * 去掉空格
         */
        str = str.trim();

        if (str.startsWith("+")) {
            str = str.substring(1);
        } else if (str.startsWith("-")) {
            str = str.substring(1);
            flag = false;
        }
        int length = str.length();
        int end = length;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            } else {
                end = i;
                break;
            }
        }
        str = str.substring(0, end);

        /**
         * 含有小数点，取整
         */
        if (str.contains(".")) {
            str = str.substring(0, str.indexOf("."));
        }

        if (!isValidInt(str)) {
            return 0;
        }

        if (str.length() > MAX_STR.length()) {
            /**
             * 如果长度大于MAX_STR的长度，正数则返回MAX_VALUE，负数则返回MIN_VALUE
             */
            return  flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (str.length() == MAX_STR.length()) {
            if (str.compareTo(MAX_STR) >= 0) {
                /**
                 * 正数则返回MAX_VALUE，负数则返回MIN_VALUE
                 */
                return  flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = Integer.parseInt(str);
                return flag ? result : result * -1;
            }
        } else {
            result = Integer.parseInt(str);
            return flag ? result : result * -1;
        }

    }

    /**
     * 判断字符串是否有效
     * 首字符包含一个负号，其余字符均为0-9之间
     *
     * @param str
     * @return
     */
    public boolean isValidInt(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
