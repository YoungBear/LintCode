package com.ysx.lintcode.easy;

/**
 * Lintcode 807. 回文数 II
 * http://www.lintcode.com/zh-cn/problem/palindrome-number-ii/
 */
public class Palindrome2 {
    public static void main(String[] args) {
        Palindrome2 test = new Palindrome2();
        for (int i = 0; i < 100; i++) {
            System.out.println(Integer.toBinaryString(i) + " : " + test.isPalindrome(i));
        }

    }

    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
}
