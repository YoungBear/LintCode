package com.ysx.leetcode.easy;

/**
 * Leetcode 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class JewelsInStones {

    public static void main(String[] args) {
        JewelsInStones test = new JewelsInStones();
        System.out.println(test.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(test.numJewelsInStones("z", "ZZ"));
    }

    /**
     * 在石头中找到宝石
     * @param J 宝石字符串，每一个字母代表一种宝石
     * @param S 所有石头字符串
     * @return S中宝石的数量
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.isEmpty() || S == null || S.isEmpty()) {
            return 0;
        }
        int lengthJ = J.length();
        int lengthS = S.length();
        int count = 0;
        for (int i = 0; i < lengthJ; i++) {
            char ch = J.charAt(i);
            for (int j = 0; j < lengthS; j++) {
                if (ch == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
