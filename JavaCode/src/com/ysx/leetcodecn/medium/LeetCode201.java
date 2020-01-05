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
    }

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int i = 0;
        while (m < n) {
            i++;
            m >>= 1;
            n >>= 1;
        }
        return m << i;
    }
}
