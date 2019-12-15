package com.ysx.leetcodecn.medium;

import java.util.Arrays;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/15 21:43
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Number55 {

    public static void main(String[] args) {
        Number55 test = new Number55();
        int[] array1 = {2, 3, 1, 1, 4};
        System.out.println(test.canJump(array1));
        int[] array2 = {3, 2, 1, 0, 4};
        System.out.println(test.canJump(array2));
    }

    /**
     * 如果位置i可以到达，则从i+1 到i+nums[i]也可达
     * 循环整个nums，对于每一个位置分别做这个动作，记录当前可以到达的最大的点
     * 初始值可达的点的下标为0
     * 如果当前点i大于当前最大可达点p，则说明当前点i不可达，且其后的所有点皆不可达，返回false
     * 如果可以循环结束，则说明最后一个点可达，返回true
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 可达的点的下标
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > p) {
                return false;
            }
            p = Math.max(p, i + nums[i]);
        }
        return true;
    }

    /**
     * 如果位置i可以到达，则从i+1 到i+nums[i]也可达
     * 循环整个nums，对于每一个位置分别做这个动作
     * 用一个布尔数组flags来记录每个位置是否可达
     * 最后返回falgs[nums.length -1]即可
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (1 == len) {
            return true;
        }
        boolean[] flags = new boolean[nums.length];
        Arrays.fill(flags, false);
        flags[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) {
                for (int j = 1; i + j < nums.length && j <= nums[i]; j++) {
                    flags[i + j] = true;
                }
            }
        }
        return flags[nums.length - 1];
    }
}
