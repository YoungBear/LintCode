package com.ysx.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 两个数组的交集
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();
        int[] nums = test.intersection(nums1, nums2);
        System.out.println("nums.length: " + nums.length);
        for (int item : nums) {
            System.out.println(item);
        }

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int item : nums1){
            set1.add(item);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (int item : set2){
            result[i++] = item;
        }
        return result;
    }
}
