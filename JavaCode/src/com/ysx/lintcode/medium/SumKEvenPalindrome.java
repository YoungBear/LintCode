package com.ysx.lintcode.medium;

/**
 * 744. Sum of first K even-length Palindrome numbers
 * http://www.lintcode.com/zh-cn/problem/sum-of-first-k-even-length-palindrome-numbers/
 * <p>
 * 返回前k个偶数位的回文数的和
 */
public class SumKEvenPalindrome {

    public static void main(String[] args) {
        SumKEvenPalindrome test = new SumKEvenPalindrome();
        System.out.println(test.sumKEven(3));
//        for (int i = 0; i < 100; i++) {
//            System.out.println("i: " + i + ", number: " + test.getNthPalindrome(i));
//        }
//        System.out.println(test.getNthPalindrom(11));
//        System.out.println(test.getNthPalindrom(1));
    }

    /**
     * @param k:
     * @return: the sum of first k even-length palindrome numbers
     */
    public int sumKEven(int k) {
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result += getNthPalindrome(i);
        }
        return result;

    }

    /**
     * 获取第n个偶数位的回文数
     * 默认f(0) = 0
     * @param n
     * @return
     */
    public int getNthPalindrome(int n) {
        if (n == 0) {
            return 0;
        }
        int m = (int) Math.log10(n);
//        System.out.println("m: " + m);
        int temp1 = (int) (n / Math.pow(10, m));
        int temp2 = (int) (Math.pow(10, 2 * m + 1) + 1);
//        System.out.println("temp1: " + temp1 + ", temp2: " + temp2);
//        System.out.println("temp1: " + temp1 + ", temp2: " + temp2);
//        int sub1= (int) (n / Math.pow(10, m) * (Math.pow(10, 2 * m + 1) + 1));
        int sub1 = temp1 * temp2;
        int sub2 = 10 * getNthPalindrome((int) (n % Math.pow(10, m)));
//        System.out.println("sub1: " + sub1 + ", sub2: " + sub2);
        int result = sub1 + sub2;
        return result;
//        double v = n / Math.pow(10, m) * (Math.pow(10, 2 * m + 1) + 1)
//                + 10 * getNthPalindrom((int) (n % Math.pow(10, m)));
//        return (int) v;


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
