package com.ysx.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        LetterCasePermutation test = new LetterCasePermutation();
        String S = "a1b2";
        List<String> list = test.letterCasePermutation(S);
        for (String item : list) {
            System.out.println(item);
        }
    }

    public List<String> letterCasePermutation(String S) {
        String lowerStr = S.toLowerCase();
        List<StringBuilder> builderList = new ArrayList<>();
        builderList.add(new StringBuilder(""));
        char[] chars = lowerStr.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                for (StringBuilder stringBuilder : builderList) {
                    stringBuilder.append(ch);
                }
            } else {
                int size = builderList.size();
                for (int j = 0; j < 2 * size; j += 2) {
                    String temp = builderList.get(j).toString();
                    builderList.get(j).append(ch);
                    builderList.add(j + 1, new StringBuilder(temp + Character.toUpperCase(ch)));
                }
            }
        }
        List<String> resultList = new ArrayList<>();
        for (StringBuilder stringBuilder : builderList) {
            resultList.add(stringBuilder.toString());
        }
        return resultList;
    }
}
