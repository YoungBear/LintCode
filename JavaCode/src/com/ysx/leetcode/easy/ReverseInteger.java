package com.ysx.leetcode.easy;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {

    public static final String MAX_STR = String.valueOf(Integer.MAX_VALUE);
    public static final String MIN_STR = String.valueOf(Integer.MIN_VALUE);

    public static void main(String[] args) {
//        System.out.println(MAX_STR);
//        System.out.println(MIN_STR);
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(120));
        System.out.println(test.reverse(-120));
        System.out.println(test.reverse(Integer.MIN_VALUE));
        System.out.println(test.reverse(Integer.MAX_VALUE));
        System.out.println(test.reverse(123));

    }

    /**
     * 使用long类型来存储结果值
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0L;
        while(x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

    /**
     * 翻转一个int值，如果越界则返回0
     * @param x
     * @return
     */
    public int reverse1(int x) {
        if (x >= 0) {
            String revStr = new StringBuilder(String.valueOf(x)).reverse().toString();
            if (revStr.length() >= MAX_STR.length() && revStr.compareTo(MAX_STR) > 0) {
                return 0;
            } else {
                return Integer.parseInt(revStr);
            }
        } else {
            if (new StringBuilder(String.valueOf(x)).reverse().toString().equals(MIN_STR)) {
                return Integer.MIN_VALUE;
            }
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            String revStr = new StringBuilder(String.valueOf(x).substring(1)).reverse().toString();
            if (revStr.equals(MAX_STR)) {
                return Integer.MIN_VALUE;
            }
            if (revStr.length() >= MAX_STR.length() && revStr.compareTo(MAX_STR) > 0) {
                return 0;
            } else {
                return Integer.parseInt(revStr) * -1;
            }
        }
    }
}
