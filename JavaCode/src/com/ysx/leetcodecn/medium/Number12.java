package com.ysx.leetcodecn.medium;

import java.util.Scanner;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/26 22:16
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description leetcode 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Number12 {
    public static void main(String[] args) {
        Number12 test = new Number12();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(test.intToRoman(scanner.nextInt()));
        }
    }

    /**
     * 贪心法 整数转罗马数字
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int n = num;
        int index = 0;
        while (n > 0) {
            if (n >= nums[index]) {
                sb.append(strs[index]);
                n -= nums[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
