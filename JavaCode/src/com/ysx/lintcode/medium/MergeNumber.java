package com.ysx.lintcode.medium;

import java.util.Arrays;

/**
 * 791. Merge Number
 * http://www.lintcode.com/zh-cn/problem/merge-number/
 */
public class MergeNumber {

    public static void main(String[] args) {
        MergeNumber test = new MergeNumber();
        int[] arrA = {1, 2, 3, 4};
        int[] arrB = {2, 8, 4, 1};
        int[] arrC = {1, 1, 1, 1};
        System.out.println(test.mergeNumber(arrA));
        System.out.println(test.mergeNumber(arrB));
        System.out.println(test.mergeNumber(arrC));

    }

    /**
     * @param numbers: the numbers
     * @return: the minimum cost
     */
    public int mergeNumber(int[] numbers) {
        int lengthA = numbers.length;
        int sum = 0;
        boolean[] visited = new boolean[lengthA];
        for (int i = 0; i < lengthA; i++) {
            visited[i] = false;
        }
        while (true) {
            int minIndex = getMinIndex(numbers, visited);
            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            int minIndex2 = getMinIndex(numbers, visited);
            if (minIndex2 == -1) {
                break;
            }
            numbers[minIndex2] = numbers[minIndex] + numbers[minIndex2];
            sum += numbers[minIndex2];
        }
        return sum;
    }

    /**
     * 获取当前未访问的数的最小的数的下标，如果都已经访问，则返回-1
     * @param numbers
     * @param visited 访问数组，已经访问为true
     * @return
     */
    public static int getMinIndex(int[] numbers, boolean[] visited) {
        int len = numbers.length;
        int minIndex = -1;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                minIndex = i;
                break;
            }
        }
        if (minIndex == -1) {
            return minIndex;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (i == minIndex) {
                continue;
            }
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
