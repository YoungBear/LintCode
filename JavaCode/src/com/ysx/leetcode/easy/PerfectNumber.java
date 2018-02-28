package com.ysx.leetcode.easy;

/**
 * Leetcode 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/description/
 */
public class PerfectNumber {

    public static void main(String[] args) {
        PerfectNumber test = new PerfectNumber();
//        System.out.println(test.checkPerfectNumber(28));
        for (int i = 1; i <= 100; i++) {
            if (test.checkPerfectNumber(i)) {
                System.out.println(i);
            }
        }

    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (num / i != i) {
                    sum += num / i;
                }
            }
        }
        return num == sum;
    }
}
