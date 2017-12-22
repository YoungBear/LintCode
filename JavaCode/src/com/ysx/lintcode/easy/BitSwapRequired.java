package com.ysx.lintcode.easy;

/**
 * 181. 将整数A转换为B
 * http://www.lintcode.com/zh-cn/problem/flip-bits/
 */
public class BitSwapRequired {

    public static void main(String[] args) {
        BitSwapRequired test = new BitSwapRequired();
        System.out.println(test.bitSwapRequired(31, 14));
        System.out.println(test.bitSwapRequired(1, -1));
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        String str = Integer.toBinaryString(a ^ b);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) == '1' ? 1 : 0;
        }
        return result;
    }
}
