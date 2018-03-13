package com.ysx.leetcode.easy;

/**
 * Leetcode 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 */
public class RotateString {

    public static void main(String[] args) {
        RotateString test = new RotateString();
        String A = "abcde";
        String B = "cdeab";
        System.out.println(test.rotateString(A, B));

        String A2 = "abcde";
        String B2 = "abced";
        System.out.println(test.rotateString(A2, B2));

    }

    public boolean rotateString(String A, String B) {
        if (null == A || null == B || A.length() != B.length()) {
            return false;
        }
        int length = A.length();
        for (int i = 0; i < length; i++) {
            String sub1 = A.substring(0, i);
            String sub2 = A.substring(i);
            String temp = sub2 + sub1;
            if (temp.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
