package com.ysx.leetcode.easy;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-05-23 22:41
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 重复地移除字符串中相邻字符相同的字符，直到没有相邻相同的字符为止，
 * 返回该最终的字符串
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String str = "aabb";
        StringBuilder sb = new StringBuilder(str);
        sb.replace(0,2,"");
        System.out.println(sb.toString());

        RemoveAllAdjacentDuplicatesInString test = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(test.removeDuplicates("aacaa"));

    }

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        boolean flag = true;
        while (flag) {
            flag = false;
            int length = sb.length();
            for (int i = 0; i < length - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    length -= 2;
                    flag = true;
                }
            }
        }
        return sb.toString();
    }
}
