package com.ysx.leetcodecn.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2020/1/2 22:17
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 676. 实现一个魔法字典
 * https://leetcode-cn.com/problems/implement-magic-dictionary/
 */
public class LeetCode676 {
    private Set<String> set;

    public LeetCode676() {
        set = new HashSet<>();
    }

    public void buildDict(String[] dict) {
        set.addAll(Arrays.asList(dict));
    }

    public boolean search(String word) {
        if (null == word || word.length() == 0) {
            return false;
        }
        Set<String> candidateSet = set.stream().filter(e -> e.length() == word.length()).collect(Collectors.toSet());
        for (String d : candidateSet) {
            if (isMatch(word, d)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断word是否和pattern有且仅有一个字符不同
     *
     * @param pattern
     * @param word
     * @return
     */
    private boolean isMatch(String pattern, String word) {
        int length = pattern.length();
        int diffCharNum = 0;
        for (int i = 0; i < length; i++) {
            if (pattern.charAt(i) != word.charAt(i)) {
                diffCharNum++;
            }
            if (diffCharNum >= 2) {
                break;
            }
        }
        return 1 == diffCharNum;
    }
}
