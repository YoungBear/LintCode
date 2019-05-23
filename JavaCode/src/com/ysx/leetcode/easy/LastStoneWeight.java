package com.ysx.leetcode.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-05-23 23:21
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class LastStoneWeight {

    public static void main(String[] args) {

        LastStoneWeight test = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
//        int[] stones = {1,3};
        System.out.println(test.lastStoneWeight(stones));

    }

    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        if (1 == size) {
            return stones[0];
        }

        while (true) {
            int maxIndex = 0;
            // 查找最大的两个数的坐标
            for (int i = 0; i < size; i++) {
                if (stones[i] > stones[maxIndex]) {
                    maxIndex = i;
                }
            }
            int secondMaxIndex = 0 == maxIndex ? 1 : 0;

            for (int i = 0; i < size; i++) {
                if (i != maxIndex && stones[i] > stones[secondMaxIndex]) {
                    secondMaxIndex = i;
                }
            }
            if (stones[secondMaxIndex] == 0) {
                return stones[maxIndex];
            } else {
                if (stones[maxIndex] == stones[secondMaxIndex]) {
                    stones[maxIndex] = 0;
                    stones[secondMaxIndex] = 0;
                } else {
                    stones[maxIndex] = stones[maxIndex] - stones[secondMaxIndex];
                    stones[secondMaxIndex] = 0;
                }
            }
        }
    }
}
