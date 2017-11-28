package com.ysx.lintcode.practice2017;

/**
 * 替换数组中的元素，使用该位置右边的最大的值来替换该位置的值。
 * 最后一个元素用-1替换
 * <p>
 * http://www.lintcode.com/zh-cn/problem/replace-with-greatest-from-right/
 */
public class ReplaceWithGreatestFromRight {

    public static void main(String[] args) {
        ReplaceWithGreatestFromRight object = new ReplaceWithGreatestFromRight();
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("\nBefore: ");
        for (int i : arr1) {
            System.out.print(String.format("%4d", i));
        }
        object.arrayReplaceWithGreatestFromRight(arr1);
        System.out.println("\nAfter: ");
        for (int i : arr1) {
            System.out.print(String.format("%4d", i));
        }

        System.out.println("\n***********************");

        int[] arr2 = {1,2};
        System.out.println("\nBefore: ");
        for (int i : arr2) {
            System.out.print(String.format("%4d", i));
        }
        object.arrayReplaceWithGreatestFromRight(arr2);
        System.out.println("\nAfter: ");
        for (int i : arr2) {
            System.out.print(String.format("%4d", i));
        }

    }


    /*
     * @param : An array of integers.
     * @return: nothing
     * 从后往前，找当前最大的数值
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        int len = nums.length;
        if (len < 1) {
            return;
        }
        int max = nums[len -1];
        nums[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = max;
            if (max < temp) {
                max = temp;
            }
        }
    }
}
