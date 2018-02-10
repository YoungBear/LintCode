package com.ysx.leetcode.easy;

/**
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        ToeplitzMatrix test = new ToeplitzMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(test.isToeplitzMatrix(matrix));

        int[][] matrix2 = {{1, 2}, {2, 2}};
        System.out.println(test.isToeplitzMatrix(matrix2));

        int[][] matrix3 = {{65, 98, 57}};
        System.out.println(test.isToeplitzMatrix(matrix3));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int value = matrix[i][0];
            for (int j = 1; j + i < m && j < n; j++) {
                if (matrix[i + j][j] != value) {
                    return false;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int value = matrix[0][j];
            for (int i = 1; i < m && i + j < n; i++) {
                if (matrix[i][i + j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
