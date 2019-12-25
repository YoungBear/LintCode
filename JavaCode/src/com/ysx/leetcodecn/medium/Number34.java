package com.ysx.leetcodecn.medium;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/25 21:59
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Number34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        result[0] = first;
        result[1] = last;
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums 整型数组
     * @param target 目标值
     * @return 查找第一个匹配的元素，成功返回下标，失败返回-1
     */
    public static int binarySearchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int result = -1;
        while (begin <= end) {
            // 这种写法是防止begin+end溢出
            int middle = begin + (end - begin) / 2;
            if (nums[middle] == target) {
                result = middle;
                end = middle - 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums 整型数组
     * @param target 目标值
     * @return 查找最后一个匹配的元素，成功返回下标，失败返回-1
     */
    public static int binarySearchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int result = -1;
        while (begin <= end) {
            // 这种写法是防止begin+end溢出
            int middle = begin + (end - begin) / 2;
            if (nums[middle] == target) {
                result = middle;
                begin = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return result;
    }
}
