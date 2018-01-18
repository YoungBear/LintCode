package com.ysx.leetcode.easy;

/**
 * 747. Largest Number At Least Twice of Others
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber test = new LargestNumber();
        int[] arrA = {3, 6, 1, 0};
        System.out.println(test.dominantIndex(arrA));
        int[] arrB = {1, 2, 3, 4};
        System.out.println(test.dominantIndex(arrB));

        int[] arrC = {0, 0, 3, 2};
        System.out.println(test.dominantIndex(arrC));
    }

    public int dominantIndex(int[] nums) {
        int lenA = nums.length;
        if (lenA < 1) {
            return -1;
        } else if (lenA == 1) {
            return 0;
        }
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < lenA; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int second = maxIndex == 0 ? nums[1] : nums[0];
        for (int i = 0; i < lenA; i++) {
            if (i == maxIndex) {
                continue;
            }
            if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= 2 * second) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}
