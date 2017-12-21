package com.ysx.lintcode;

/**
 * http://www.lintcode.com/zh-cn/problem/kth-largest-element/
 * 第k大元素
 */
public class LargestK {

    public static void main(String[] args) {
        LargestK  largestK = new LargestK();
        int[] arr1 = {9,3,2,4,8};
        System.out.println(largestK.kthLargestElement(3, arr1));
        int[] arr2 = {1,2,3,4,5};
        System.out.println(largestK.kthLargestElement(1, arr2));
        System.out.println(largestK.kthLargestElement(2, arr2));
        System.out.println(largestK.kthLargestElement(3, arr2));
    }

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (k < 0 || nums.length < 1) {
            return 0;
        }
        int[] result = new int[k];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            insertNum(nums[i], result);
        }
        return result[k - 1];
    }

    /**
     * 存储最大的k个数，然后将数字n插入到该有序数组中
     * @param n 待插入的数
     * @param nums 有序数组
     */
    public static void insertNum(int n, int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (n > nums[i]) {
                for (int j = len - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[i] = n;
                return;
            }
        }
    }
}
