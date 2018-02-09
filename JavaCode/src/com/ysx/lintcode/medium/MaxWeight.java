package com.ysx.lintcode.medium;

/**
 * 785. 最大权值和路径
 * http://www.lintcode.com/zh-cn/problem/maximum-weighted-sum-path/
 */
public class MaxWeight {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {3, 5, 6, 7},
                {9, 10, 1, 2},
                {4, 4, 5, 5}
        };
        MaxWeight test = new MaxWeight();
        System.out.println(test.maxWeight(nums));

        int[][] nums2 = {
                {1,2,3},
                {4,5,6},
                {7,9,8}
        };
        System.out.println(test.maxWeight(nums2));

    }

    /**
     * @param nums: the n x m grid
     * @return: the maximum weighted sum
     */
    public int maxWeight(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int m = nums.length;
        int n = nums[0].length;
        int[][] costs = new int[m][n];
        costs[0][n - 1] = nums[0][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            costs[0][j] = costs[0][j + 1] + nums[0][j];
        }
        for (int i = 1; i < m; i++) {
            costs[i][n - 1] = costs[i - 1][n - 1] + nums[i][n - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                costs[i][j] = nums[i][j] + Math.max(costs[i - 1][j], costs[i][j + 1]);
            }
        }
        return costs[m-1][0];
    }


}
