package com.ysx.leetcodecn.medium;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/11 22:00
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Number63 {
    public static void main(String[] args) {
        Number63 test = new Number63();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m <= 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        boolean iBlock = false;
        for (int i = 0; i < m; i++) {
            if (iBlock) {
                dp[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1) {
                    iBlock = true;
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            }
        }
        boolean jBlock = false;
        for (int j = 0; j < n; j++) {
            if (jBlock) {
                dp[0][j] = 0;
            } else {
                if (obstacleGrid[0][j] == 1) {
                    jBlock = true;
                    dp[0][j] = 0;
                } else {
                    dp[0][j] = 1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 递推关系
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
