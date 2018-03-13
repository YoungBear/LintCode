package com.ysx.lintcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Lintcode 828. Word Pattern
 * http://www.lintcode.com/zh-cn/problem/word-pattern/
 * Leetcode 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(test.wordPattern(pattern, str));

        String pattern2 = "abba";
        String str2 = "dog dog dog dog";
        System.out.println(test.wordPattern(pattern2, str2));
    }

    /**
     * @param pattern: a string, denote pattern string
     * @param str:     a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strArray[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strArray[i])) {
                    return false;
                }
                map.put(ch, strArray[i]);
            }
        }
        return true;
    }
}
