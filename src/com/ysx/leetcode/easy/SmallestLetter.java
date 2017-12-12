package com.ysx.leetcode.easy;

/**
 * 744. Find Smallest Letter Greater Than Target
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * 在一组字母列表中，找到比target大的的最小的一个字母。
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that is larger than the given target.
 *  Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * Note:
 * 1. letters has a length in range [2, 10000].
 * 2. letters consists of lowercase letters, and contains at least 2 unique letters.
 * 3. target is a lowercase letter.
 */
public class SmallestLetter {

    public static void main(String[] args) {
        SmallestLetter test = new SmallestLetter();
        char [] letters = {'c', 'f', 'j'};
//        char target = 'a';
//        char target = 'c';
        char target = 'd';
        System.out.println(test.nextGreatestLetter(letters, target));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        /**
         * 如果target比第一个字母还小，则返回第一个字母
         */
        if (target < letters[0]) {
            return letters[0];
        }
        /**
         * 如果target和第一个字母相同，则找到第一个大于target的字母并返回
         */
        if (target == letters[0]) {
            for (int i = 1; i < length; i++) {
                if (target < letters[i]) {
                    return letters[i];
                }
            }
        }
        /**
         * 如果target大于等于最后一个(最大的一个)元素，则需要采用wrap around策略，返回第一个元素
         */
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        /**
         * 其它情况
         * 给minChar赋予'z'，然后再找到最小的大于target的元素
         */
        char minChar = 'z';
        for (int i = 0; i < length; i++) {
            if (letters[i] > target && letters[i] < minChar) {
                minChar = letters[i];
            }
        }
        return minChar;
    }
}
