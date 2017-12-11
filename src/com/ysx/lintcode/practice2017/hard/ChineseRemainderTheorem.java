package com.ysx.lintcode.practice2017.hard;

/**
 * 中国剩余定理
 * http://www.lintcode.com/zh-cn/problem/chinese-remainder-theorem/
 *
 */
public class ChineseRemainderTheorem {

    public static void main(String[] args) {
        ChineseRemainderTheorem test = new ChineseRemainderTheorem();
//        int []nums = {3,4,5};
//        int []rems = {2,3,1};
//        int []nums = {5,7,17,13,23,41,31,2};
//        int []rems = {1,3,7,4,22,29,16,1};
        int []nums = {3,4,5,11};
        int []rems = {2,3,1,7};
        System.out.println(test.remainderTheorem(nums, rems));
    }

    /**
     * 找到最大的数，用满足它的集合来遍历
     *
     * @param num: the given array
     * @param rem: another given array
     * @return: The minimum positive number of conditions to meet the conditions
     */
    public int remainderTheorem(int[] num, int[] rem) {
        // write your code here
        int length = num.length;
        // 找到最大的数，用满足它的集合来遍历
        int maxNum = num[0];
        int maxRem = rem[0];
        for (int i = 1; i < length; i++) {
            if (num[i] > maxNum) {
                maxNum = num[i];
                maxRem = rem[i];
            }
        }
        int n = 0;
        for(int i = 0; n < Integer.MAX_VALUE ;i++) {
            n = maxNum * i + maxRem;
            boolean flag = true;
            for (int j = 0; j < length; j++) {
                if (n % num[j] != rem[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return n;
            }
        }
        return -1;
    }

    /**
     * 逐个去遍历，会超时
     *
     * @param num: the given array
     * @param rem: another given array
     * @return: The minimum positive number of conditions to meet the conditions
     */
    public int remainderTheorem1(int[] num, int[] rem) {
        // write your code here
        int length = num.length;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            boolean flag = true;
            for (int j = 0; j < length; j++) {
                if (i % num[j] != rem[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
