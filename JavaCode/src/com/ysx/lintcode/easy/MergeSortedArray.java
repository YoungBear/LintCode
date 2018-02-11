package com.ysx.lintcode.easy;

/**
 * Lintcode 64. 合并排序数组
 * http://www.lintcode.com/zh-cn/problem/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        int[] A = {1, 2, 3, -1, -1};
        int m = 3;
        int[] B = {4, 5};
        int n = 2;
        test.mergeSortedArray(A, m, B, n);
        for (int i = 0; i < m + n; i++) {
            System.out.println(A[i]);
        }
    }

    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] > B[j]) {
                temp[k++] = B[j++];
            } else {
                temp[k++] = A[i++];
            }
        }
        while (i < m) {
            temp[k++] = A[i++];
        }
        while (j < n) {
            temp[k++] = B[j++];
        }
        for (int t = 0; t < k; t++) {
            A[t] = temp[t];
        }
    }
}
