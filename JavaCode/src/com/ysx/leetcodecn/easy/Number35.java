package com.ysx.leetcodecn.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/25 22:06
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Number35 {

    /**
     * 二分查找插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int begin = 0;
        int end = nums.length - 1;
        int middle = (begin + end) / 2;
        while(begin <= end) {
            if (nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (begin + end) / 2;
        }
        return begin > end ? begin : end;
    }
}
