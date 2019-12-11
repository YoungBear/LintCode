package com.ysx.leetcodecn.medium;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/11 21:57
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Number62 {

    public static void main(String[] args) {
        Number62 test = new Number62();
        System.out.println(test.uniquePaths(3, 2));
        System.out.println(test.uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 递推关系
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
