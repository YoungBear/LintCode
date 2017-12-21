package com.ysx.lintcode.practice2017.medium;

/**
 * 728. 3个不同的因子
 * http://www.lintcode.com/zh-cn/problem/three-distinct-factors/
 * 给一 正整数 n (1 <= n <= 10^18). 判断这个数是否正好只有 3 个不同的因子, 如果正好有 3 个不同的因子就返回 true, 否则返回 false
 */
public class Factor {

    public static void main(String[] args) {
        Factor test = new Factor();
        System.out.println(test.isThreeDisctFactors(10000001400000049L));
    }

    /*
     * @param n: the given number
     * @return: true if it has exactly three distinct factors, otherwise false
     * 思路：如果n只有3个因子，即只能为1,x,n,x是n的平方根，并且x是素数。
     * 所以，我们只需要判断n的平方根是否为素数即可。
     * 4,9,25,49...
     */
    public boolean isThreeDisctFactors(long n) {
        long x = (long) Math.sqrt(n);
        /**
         * 如果n不是平方数，则返回false
         */
        if (x * x != n) {
            return false;
        }
        return isPrime(x);
    }

    /**
     * 判断是否为素数
     * @param n
     * @return
     */
    public static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for(int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
