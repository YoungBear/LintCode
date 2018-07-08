package com.ysx.leetcode.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/7/8 21:06
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 矩阵的转置
 * Leetcode 868. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(A);
        System.out.println("----------------");
        TransposeMatrix test = new TransposeMatrix();
        int[][] B = test.transpose(A);
        printMatrix(B);

        int[][] A2 = {{1,2,3},{4,5,6}};
        printMatrix(A2);
        System.out.println("----------------");
        int[][] B2 = test.transpose(A2);
        printMatrix(B2);
    }

    public static void printMatrix(int[][] A){
        for (int i = 0; i< A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
