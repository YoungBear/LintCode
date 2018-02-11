package com.ysx.lintcode.easy;

/**
 * 101. 删除排序数组中的重复数字 II
 * http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-array-ii/
 * 允许出现两次重复
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        RemoveDuplicates2 test = new RemoveDuplicates2();
//        int[] nums = {1, 1, 2};
        int[] nums = {-14, -14, -13, -13, -13, -13, -13, -13, -13, -12, -12, -12, -12, -11,
                -10, -9, -9, -9, -8, -7, -5, -5, -5, -5, -4, -3, -3, -2, -2, -2, -2, -1, -1, -1, -1, -1,
                0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10,
                11, 11, 11, 12, 12, 12, 13, 14, 14, 14, 14, 15, 16, 16, 16, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20,
                21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 23, 23, 24, 25, 25};
        System.out.println(test.removeDuplicates(nums));
        System.out.println("*************");

        for (int item : nums) {
            System.out.println(item);
        }
    }

    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len - 1) {
            if (nums[i] == nums[i + 1]) {
                int count = 0;
                for (int j = i + 2; j < len; j++) {
                    if (nums[i] != nums[j]) {
                        break;
                    }
                    count++;
                }
                if (count > 0) {
                    for (int j = i + 2; j + count < len; j++) {
                        nums[j] = nums[j + count];
                    }
                    len -= count;
                }
            }
            i++;
        }
        return len;
    }
}
