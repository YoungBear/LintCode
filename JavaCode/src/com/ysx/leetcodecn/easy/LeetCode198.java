package com.ysx.leetcodecn.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/31 18:34
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class LeetCode198 {
    /**
     * 动态规划
     * dp[i] 表示前i个节点的最优解
     * dp[i] = max(dp[i-1], dp[i-2] + A[i])
     * 即 当 i >= 2时，dp[i]可以去两种情况，一种是不取i节点的值，而使用dp[i-1]；另一种是取i节点的值，加上dp[i-2]
     * 优化：dp数组可以优化为两个变量，用来表示前两步步取值
     * 参考：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int n : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + n);
            preMax = temp;
        }
        return curMax;
    }
}
