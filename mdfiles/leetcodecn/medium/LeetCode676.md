# [LeetCode 676. 实现一个魔法字典](https://leetcode-cn.com/problems/implement-magic-dictionary/)

## 1. 题目描述

实现一个带有buildDict, 以及 search方法的魔法字典。

对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。

对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。



## 2. 思路

使用一个集合来保存字典中的值
search时，先筛选长度相同的字符串，然后遍历每一个串。如果存在word和pattern有且仅有一个字符不同的情况，则返回true。循环完成后，如果还不存在，则返回false。
**执行结果：**
执行用时 :15 ms, 在所有 java 提交中击败了36.53%的用户
内存消耗 :36.3 MB, 在所有 java 提交中击败了88.24%的用户

## 3. java 代码

```java
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
```

## 4. 优化





```java
package com.ysx.leetcodecn.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2020/1/2 22:19
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 676. 实现一个魔法字典
 * https://leetcode-cn.com/problems/implement-magic-dictionary/
 * 优化
 */
public class LeetCode676_1 {

    private Set<String> set;
    private Map<Integer, Map<String, Integer>> map;

    public LeetCode676_1() {
        set = new HashSet<>();
        map = new HashMap<>();
    }

    public void buildDict(String[] dict) {
        for (String k : dict) {
            set.add(k);
            int length = k.length();
            if (map.containsKey(length)) {
                // stringIntegerMap 用来记录生成该key的串的个数
                Map<String, Integer> stringIntegerMap = map.get(length);
                for (int i = 0; i < length; i++) {
                    String tempStr = k.substring(0, i) + "*" + k.substring(i + 1, length);
                    stringIntegerMap.put(tempStr, stringIntegerMap.getOrDefault(tempStr, 0) + 1);
                }
            } else {
                Map<String, Integer> stringIntegerMap = new HashMap<>();
                for (int i = 0; i < length; i++) {
                    String tempStr = k.substring(0, i) + "*" + k.substring(i + 1, length);
                    stringIntegerMap.put(tempStr, stringIntegerMap.getOrDefault(tempStr, 0) + 1);
                }
                map.put(length, stringIntegerMap);
            }
        }
    }

    public boolean search(String word) {
        if (null == word || word.length() == 0) {
            return false;
        }
        int length = word.length();
        if (map.containsKey(length)) {
            Map<String, Integer> stringIntegerMap = map.get(length);
            for (int i = 0; i < length; i++) {
                String tempStr = word.substring(0, i) + "*" + word.substring(i + 1, length);
                int count = stringIntegerMap.getOrDefault(tempStr, 0);
                // 如果有多于1个的串生成了该模式，则返回true
                // 或者如果只有1个串生成了该模式，且不是该word本身，则返回true
                if (count > 1 || count == 1 && !set.contains(word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
```



