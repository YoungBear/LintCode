package com.ysx.lintcode.easy;

/**
 * 749. 约翰的后花园
 * http://www.lintcode.com/zh-cn/problem/johns-backyard-garden/
 */
public class JohnGarden {

    public static void main(String[] args) {
        JohnGarden test = new JohnGarden();
        System.out.println("10: " + test.isBuild(10));
        System.out.println("5: " + test.isBuild(5));

    }

    private static final int VALUE_X = 3;
    private static final int VALUE_Y = 7;

    private static final String YES_STR = "YES";
    private static final String NO_STR = "NO";

    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        for (int i = 0; i * VALUE_X <= x; i++) {
            int t = x - VALUE_X * i;
            int k = t / VALUE_Y;
            if (VALUE_Y * k == t) {
                return YES_STR;
            }
        }
        return NO_STR;
    }
}
