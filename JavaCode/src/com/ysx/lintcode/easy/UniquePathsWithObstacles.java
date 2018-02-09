package com.ysx.lintcode.easy;

/**
 * 115. 不同的路径 II
 * http://www.lintcode.com/zh-cn/problem/unique-paths-ii/
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles test = new UniquePathsWithObstacles();
        int[][] grids = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(test.uniquePathsWithObstacles(grids));
    }

    /**
     * 有障碍
     */
    private static final int HAS_GRID = 1;
    /**
     * 无障碍
     */
    private static final int NO_GRID = 0;


    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == HAS_GRID) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == HAS_GRID) {
                paths[0][j] = 0;
            } else {
                paths[0][j] = paths[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == HAS_GRID) {
                paths[i][0] = 0;
            } else {
                paths[i][0] = paths[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == HAS_GRID) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
