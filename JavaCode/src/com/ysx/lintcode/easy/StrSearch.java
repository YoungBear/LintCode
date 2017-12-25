package com.ysx.lintcode.easy;

/**
 * 13. 字符串查找
 * http://www.lintcode.com/zh-cn/problem/strstr/
 */
public class StrSearch {

    public static void main(String[] args) {
        StrSearch test = new StrSearch();

        String testSource = "abcdabcdefg";
        String testTarget = "bcd";
        System.out.println(test.strStr(testSource, testTarget));

    }

    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        return source.indexOf(target);
    }
}
