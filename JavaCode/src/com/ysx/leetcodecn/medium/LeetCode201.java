package com.ysx.leetcodecn.medium;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2020/1/5 10:29
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class LeetCode201 {

    public static void main(String[] args) {
        LeetCode201 demo = new LeetCode201();
        System.out.println(demo.rangeBitwiseAnd(5, 7));
        System.out.println(Integer.highestOneBit(6));
    }

    /**
     * m < n 时，找到 m 和 n 二进制高位第一个不相同的位置，即m[i]=0,n[i]=1
     * 将 i 位置之前的全部置为1（包括i），其后全部置为0，得到数 x
     * 然后将 m 与这个数 x 按位与即可
     * Integer.highestOneBit(k) 是保留最高位的1，其他位置为0
     * m ^ n，即m与n按位异或，可以找到第一个不同的位置i
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        return m & ~Integer.highestOneBit(m ^ n) + 1;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    public int rangeBitwiseAnd3(int m, int n) {
        int i = 0;
        while (m < n) {
            i++;
            m >>= 1;
            n >>= 1;
        }
        return m << i;
    }
}
