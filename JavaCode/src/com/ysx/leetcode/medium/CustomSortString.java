package com.ysx.leetcode.medium;

/**
 * Leetcode: 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/description/
 */
public class CustomSortString {

    public static void main(String[] args) {
        CustomSortString test = new CustomSortString();
        String S = "cba";
        String T = "abcfde";
        String result = test.customSortString(S, T);
        System.out.println(result);
    }

    public String customSortString(String S, String T) {
        char[] arrayT = T.toCharArray();
        /**
         * 使用indexOf，进行冒泡排序
         */
        int length = arrayT.length;
        boolean flag = true;
        for (int i = 0; flag && i < length; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                    char temp = arrayT[j];
                    arrayT[j] = arrayT[j + 1];
                    arrayT[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return String.valueOf(arrayT);
    }
}
