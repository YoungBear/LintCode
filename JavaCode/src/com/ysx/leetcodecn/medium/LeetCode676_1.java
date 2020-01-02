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
