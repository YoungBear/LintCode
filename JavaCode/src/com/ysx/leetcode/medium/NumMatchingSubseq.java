package com.ysx.leetcode.medium;

/**
 * Leetcode 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 */
public class NumMatchingSubseq {

    public static void main(String[] args) {
        NumMatchingSubseq test = new NumMatchingSubseq();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(test.numMatchingSubseq(S, words));
    }

    public int numMatchingSubseq(String S, String[] words) {
        int num = 0;
        int lengthS = S.length();
        for (String word : words) {
            int wordLength = word.length();
            boolean flag = false;
            int i = 0;
            int j = 0;
            while (i < lengthS && j < wordLength) {
                if (S.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                    flag = true;
                } else {
                    i++;
                    flag = false;
                }
            }
            if (j == wordLength && flag) {
                num++;
            }
        }
        return num;
    }
}
