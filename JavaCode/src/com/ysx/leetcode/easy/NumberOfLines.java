package com.ysx.leetcode.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/1 11:23
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 806. Number of Lines To Write String
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 */
public class NumberOfLines {

    private static final int LINE_SIZE = 100;

    public static void main(String[] args) {
        NumberOfLines test = new NumberOfLines();
        int[] widths = {
                10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };
        String S = "abcdefghijklmnopqrstuvwxyz";
        test.numberOfLines(widths, S);

        int[] widths1 = {
                4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };
        String S1 = "bbbcccdddaaa";
        test.numberOfLines(widths1, S1);

    }

    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        char[] chars = S.toCharArray();
        int currentWidth = 0;
        for (int i = 0; i < chars.length; i++) {
            int w = widths[chars[i] - 'a'];
            if (currentWidth + w > LINE_SIZE){
                result[0]++;
                currentWidth = w;
            } else {
                currentWidth += w;
            }
        }
        result[0] += 1;
        result[1] = currentWidth;
        System.out.println(result[0]);
        System.out.println(result[1]);
        return result;
    }
}
