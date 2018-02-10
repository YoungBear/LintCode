package com.ysx.lintcode.easy;

/**
 * Lintcode 28. 搜索二维矩阵
 * http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix/
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix test = new SearchMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println(test.searchMatrix(matrix, target));
    }

    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                index = i;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (target == matrix[index][j]) {
                return true;
            }
        }
        return false;
    }
}
