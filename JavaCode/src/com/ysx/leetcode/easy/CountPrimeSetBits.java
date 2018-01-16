package com.ysx.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 762. Prime Number of Set Bits in Binary Representation
 * <p>
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 */
public class CountPrimeSetBits {

    public static void main(String[] args) {
        CountPrimeSetBits test = new CountPrimeSetBits();
        System.out.println(test.countPrimeSetBits(6, 10));
        System.out.println(test.countPrimeSetBits(10, 15));
    }

    private static final List<Integer> PRIME_LIST = Arrays.asList(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31
    );


    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (PRIME_LIST.contains(count1(i))) {
                result++;
            }
        }
        return result;
    }

    public static int count1(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n /= 2;
        }
        return result;
    }
}
