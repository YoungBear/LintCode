package com.ysx.lintcode.easy;

/**
 * 114. 不同的路径
 * http://www.lintcode.com/zh-cn/problem/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(3, 3));
        System.out.println(test.uniquePaths(4, 5));

    }

    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            nums[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }
}
