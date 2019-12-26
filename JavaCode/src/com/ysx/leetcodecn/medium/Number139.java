package com.ysx.leetcodecn.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/26 22:43
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
public class Number139 {

    public static void main(String[] args) {
        Number139 test = new Number139();
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(test.wordBreak(s1, wordDict1));
        System.out.println(test.wordBreak(s2, wordDict2));
        System.out.println(test.wordBreak(s3, wordDict3));
    }

    /**
     * 动态规划判断单词拆分
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i] 表示 s.substring(0, i+1) 是否可以拆分
        // 即 dp[i] 表示 wordBreak(s.substring(0, i+1), wordDict)
        boolean[] dp = new boolean[len];
        HashSet<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < len; i++) {
            // 如果字典包含 s.substring(0, i+1)，则 dp[i]=true
            if (wordSet.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            // 如果不包含 s.substring(0, i+1),判断 s.substring(0, i+1) 这个子串是否可以被拆分
            // 即求dp[i]
            for (int j = 0; j < i; j++) {
                // 状态转移公式：
                if (dp[j] && wordSet.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
