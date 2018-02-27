package com.ysx.leetcode.easy;

/**
 * Leetcode 788. Rotated Digits
 * https://leetcode.com/problems/rotated-digits/description/
 */
public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits test = new RotatedDigits();
        System.out.println(test.rotatedDigits(30));

    }

    public int rotatedDigits(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodDigit(i)) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean isGoodDigit(int n) {
        int t = n;
        boolean flag = false;
        while (t > 0) {
            int remainder = t % 10;
            if (3 == remainder || 4 == remainder || 7 == remainder) {
                return false;
            } else if (2 == remainder || 5 == remainder || 6 == remainder || 9 == remainder) {
                flag = true;
            }
            t /= 10;
        }
        return flag;
    }

}
