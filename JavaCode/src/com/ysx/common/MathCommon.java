package com.ysx.common;

import java.util.BitSet;

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
     *
     * @param n 自然数
     * @return 是否为素数
     */
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
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
     *
     * @param n 正整数
     * @return 是否为2的幂
     */
    public static boolean is2Power(int n) {
        return 0 == (n & (n - 1));
    }

    /**
     * 筛选法生成正整数n以内素数列表
     * 描述：
     * 初始设置BitSet从0到n的值均为true
     * 从2开始，由于2是素数，所以将所有2的倍数排除
     * 然后下一个素数是3，则将所有3的倍数排除
     * 下一个素数是5，将所有5的倍数排除
     * ...
     * 直到n
     * BitSet中剩余的值为true的index即为素数
     *
     * @param n 正整数
     * @return 素数表，用 BitSet 表示
     */
    public static BitSet genPrimeBitSet(int n) {
        BitSet primeBitSet = new BitSet(n);
        primeBitSet.set(0, n, true);
        primeBitSet.set(0, false);
        primeBitSet.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (primeBitSet.get(i)) {
                for (int j = 2 * i; j <= n; j += i) {
                    primeBitSet.set(j, false);
                }
            }
        }
        return primeBitSet;
    }

    public static void main(String[] args) {
        // 获取n以内的所有素数
        int n = 1000;
        long begin = System.currentTimeMillis();
        BitSet primeBitSet = genPrimeBitSet(n);
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i <= n; i++) {
            if (primeBitSet.get(i)) {
                sb.append(i).append(",");
                num++;
            }
        }
        long end = System.currentTimeMillis();
        sb.delete(sb.toString().length() - 1, sb.toString().length());
        String desc = n + " 以内共 " + num + " 个素数，耗时 " + (end - begin) + "毫秒";
        sb.append(System.lineSeparator()).append(desc);
        System.out.println(sb.toString());
    }
}
