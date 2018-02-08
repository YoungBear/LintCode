package com.ysx.lintcode.easy;

/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
public class KthPrimeNumber {

    public static void main(String[] args) {
        KthPrimeNumber test = new KthPrimeNumber();
        System.out.println(test.kthPrime(2));
        System.out.println(test.kthPrime(3));
        System.out.println(test.kthPrime(5));
        System.out.println(test.kthPrime(7));

    }

    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                index++;
            }
        }
        return index;
    }

    /**
     * 判断n是否为素数
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n ==0 || n == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
