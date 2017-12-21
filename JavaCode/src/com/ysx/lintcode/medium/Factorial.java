package com.ysx.lintcode.medium;

/**
 * http://www.lintcode.com/zh-cn/problem/last-digit-by-factorial-divide/
 * 729. 阶乘除法的最后一位数
 * 给出两个数 A 和 B, 其中 B >= A. 我们需要计算结果 F 的最后一位数是什么,
 * 其中F = B! / A!(1 <= A, B <= 10^18, A 和 B 非常大)
 */
public class Factorial {

    public static void main(String[] args) {
        Factorial test = new Factorial();
        System.out.println(test.computeLastDigit(1L, 4L));
    }

    /*
     * @param A: the given number
     * @param B: another number
     * @return: the last digit of B! / A!
     * 思路：
     * F = B! / A!，即F = B*(B-1)*(B-2)*...*(A + 1)
     * 如果B-A >= 10，则表明B和A之间，肯定存在一个数为10的倍数，则这种情况下，末位为0
     * 如果B-A < 10，则只需要计算末位的结果即可。从A+1一直乘到B，用一个int值保存末位值。
     */
    public int computeLastDigit(long A, long B) {
        if (B - A >= 10) {
            return 0;
        }
        int result = 1;
        for (long i = A + 1; i <= B; i++) {
            int temp = (int) (i % 10);
            result = (result * temp) % 10;
        }
        return result;
    }
}
