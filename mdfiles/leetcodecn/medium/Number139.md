# leetcode 139. [单词拆分](https://leetcode-cn.com/problems/word-break/)

## 1. 题目描述

给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

## 2. 思路

使用动态规划。

使用`boolean[] dp = new boolean[s.length()]`布尔数组。

- 其中dp[i] 表示 s.substring(0, i+1) 是否可以拆分。即 dp[i] 表示 wordBreak(s.substring(0, i+1), wordDict)。

- 对于dp[i]，如果dp[i-1]为true，且wordDict中包含s.substring(i, s.length)，则dp[i]也为true。此为状态转移公式。
- 最终，返回dp[s.length() -1]即可。



## 3. java 代码

```java
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
```

## 4. 测试代码

```java
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
}

```

