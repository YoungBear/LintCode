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
        System.out.println(test.sumKEven(99));
    }

    /**
     * @param k:
     * @return: the sum of first k even-length palindrome numbers
     */
    public int sumKEven(int k) {
        int n = (int) Math.log10(k + 1);
        System.out.println("n: " + n);

        int sum = 0;
        /**
         * 先计算f(10^n - 1)的值
         */
        int temp1 = (int) (45 * Math.pow(10, n - 1));
        int temp2 = (int) (10 * (Math.pow(100, n) - 1) / 99 + n);
        System.out.println(temp1 + "  " + temp2);
        int sub1 = (int) (45 * Math.pow(10, n - 1) * ((10 * (Math.pow(100, n) - 1)) / 99 + n));

        int sub2Count = (int) (k - Math.pow(10, n) + 1);
        System.out.println("sub2Count: " + sub2Count);

        sum += sub1;
        System.out.println("sum: " + sum);

        return sum;

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
