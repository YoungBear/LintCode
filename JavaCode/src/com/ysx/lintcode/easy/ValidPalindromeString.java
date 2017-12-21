package com.ysx.lintcode.easy;

/**
 * 415. 有效回文串
 * http://www.lintcode.com/zh-cn/problem/valid-palindrome/
 * 在这个题目中，我们将空字符串判定为有效回文。
 */
public class ValidPalindromeString {

    public static void main(String[] args) {
        ValidPalindromeString test = new ValidPalindromeString();
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(test.isPalindrome(str1));
        System.out.println(test.isPalindrome(str2));


    }


    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (null == s) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')){
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        return str1.equalsIgnoreCase(str2);

    }
}
