package com.ysx.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/10 21:37
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 830. Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        LargeGroupPositions test = new LargeGroupPositions();
        String S1 = "abbxxxxzzy";
        String S2 = "abc";
        String S3 = "abcdddeeeeaabbbcd";
        test.largeGroupPositions(S1);
        test.largeGroupPositions(S2);
        test.largeGroupPositions(S3);

    }

    private static final int LARGE_SIZE = 3;

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int j = i + 1;
            while(j < S.length() && S.charAt(j) == ch) {
                j++;
            }
            if (j - i >= LARGE_SIZE) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j - 1);
                resultList.add(list);
                i = j - 1;
            }
        }
        return resultList;
    }
}
