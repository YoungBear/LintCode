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
        System.out.println(test.sumKEven(1000));
    }

    /**
     * @param k:
     * @return: the sum of first k even-length palindrome numbers
     * 设f(n)为第n个偶数长度的回文数
     * 则f(1)为11，f(2)为22...f(10)为1001
     * 可以看到规律，f(n)为将n作为字符串，翻转后，两个串拼起来的数字
     * 参考：
     * http://www.geeksforgeeks.org/sum-first-k-even-length-palindrome-numbers/
     */
    public int sumKEven(int k) {
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            String s = String.valueOf(i);
            String s2 = s + new StringBuilder().append(s).reverse().toString();
            int cur = Integer.parseInt(s2);
            System.out.println("i: " + i + ", cur: " + cur);
            sum += cur;
        }
        return sum;
    }
}
