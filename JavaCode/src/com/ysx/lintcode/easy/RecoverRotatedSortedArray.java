package com.ysx.lintcode.easy;

import java.util.*;

/**
 * Lintcode 39. 恢复旋转排序数组
 * http://www.lintcode.com/zh-cn/problem/recover-rotated-sorted-array/
 */
public class RecoverRotatedSortedArray {

    /**
     * 注意：使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
     * 它的add/remove/clear方法会抛出UnsupportedOperationException异常
     * 参考：阿里巴巴Java编程规范
     * @param args
     */
    public static void main(String[] args) {
        RecoverRotatedSortedArray test = new RecoverRotatedSortedArray();
        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println("before...");
        for (Integer item : nums) {
            System.out.println(item);
        }
        test.recoverRotatedSortedArray(nums);
        System.out.println("after...");
        for (Integer item : nums) {
            System.out.println(item);
        }
    }

    /*
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int len = nums.size();
        int t = -1;
        for (int i = 0; i < len - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                t = i;
            }
        }
        for (int i = 0; i < t + 1; i++) {
            Integer item = nums.get(0);
            nums.remove(item);
            nums.add(item);
        }
    }
}
