package com.ysx.common;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-06-01 06:25
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 常用数学公共函数
 */
public class MathCommon {

    /**
     * 判断n是否为素数
     * @param n 自然数
     * @return 是否为素数
     */
    public static boolean isPrime(int n) {
        if (n ==0 || n == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断正整数n是否为2的幂
     * @param n 正整数
     * @return 是否为2的幂
     */
    public static boolean is2Power(int n) {
        return 0 == (n & (n -1));
    }
}
