package com.ysx.leetcodecn.medium;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/31 18:50
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class LeetCode213 {

    /**
     * 动态规划
     * 参考Leetcode198的方案，由于节点首尾相邻，所以不能同时选择第一个和最后一个节点
     * 思路：可以先计算0-(n-1)的节点的值max1，再计算1-n的节点的值max2，选择max(max1, max2)即可
     * 注意：需要处理长度为1的情况
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }
        int preMax = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        int max1 = curMax;
        preMax = 0;
        curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        int max2 = curMax;

        return Math.max(max1, max2);
    }
}
