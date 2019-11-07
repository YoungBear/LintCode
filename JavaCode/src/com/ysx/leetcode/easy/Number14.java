package com.ysx.leetcode.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/11/7 23:01
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Number14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Number14 demo = new Number14();
        System.out.println(demo.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0) {
            return result.toString();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char curChar = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    flag = false;
                    break;
                }
                if (strs[j].charAt(i) != curChar) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.append(curChar);
            } else {
                break;
            }
        }
        return result.toString();
    }
}
