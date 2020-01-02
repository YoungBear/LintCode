package com.ysx.leetcodecn.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2020/1/2 22:01
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 1304. 和为零的N个唯一整数
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class LeetCode1304 {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0, j = n / 2; i < n / 2; i++, j--) {
            arr[i] = j;
            arr[n - i - 1] = -j;
        }
        return arr;
    }
}
