package com.ysx.lintcode.easy;

/**
 * 491. 回文数
 * http://www.lintcode.com/zh-cn/problem/palindrome-number/
 *
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(1234321));
//        System.out.println(test.isPalindrome(2147483647));
    }

    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int p = num;
        int q = 0;
        /**
         * 当num为Integer.MAX_VALUE: 2147483647时
         * 翻转过来，就会超过int的最大范围，导致出错
         * 所以翻转的时候不获取最高位，这时候结果q就少一位
         * 判断(q == num / 10 && p == num % 10)就满足条件
         */
        while (p >= 10) {
            q = q * 10 + p % 10;
            p = p / 10;
        }
        return q == num / 10 && p == num % 10;
    }
}
