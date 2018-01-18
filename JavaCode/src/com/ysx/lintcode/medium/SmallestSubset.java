package com.ysx.lintcode.medium;

import java.util.Arrays;

/**
 * 761. Smallest Subset
 * http://www.lintcode.com/zh-cn/problem/smallest-subset/
 */
public class SmallestSubset {

    public static void main(String[] args) {
        SmallestSubset test = new SmallestSubset();
        int[] arr1 = {3,1,7,1};
        int[] arr2 = {2,1,2};
        System.out.println(test.minElements(arr1));
        System.out.println(test.minElements(arr2));

    }

    /**
     * @param nums: an array of non-negative integers
     * @return: minimum number of elements
     * 思路，先排序，计算出数组元素的和，然后从后往前遍历，累加元素，当累加的数大于剩余的数时，满足条件
     */
    public int minElements(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        int curSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (curSum > sum - curSum) {
                return nums.length - i - 1;
            } else {
                curSum += nums[i];
            }
        }
        return 0;
    }
}
