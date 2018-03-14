package com.ysx.lintcode.easy;

import java.util.*;

/**
 * Lintcode 830. 字符串排序
 * http://www.lintcode.com/zh-cn/problem/string-sort/
 */
public class StringSort {

    public static void main(String[] args) {
        StringSort test = new StringSort();
        String str = "bloomberg";
        System.out.println(test.stringSort(str));

    }

    /**
     * @param str: the string that needs to be sorted
     * @return: sorted string
     */
    public String stringSort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        List<Character> keyList = new ArrayList<>(map.keySet());
        keyList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        keyList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char ch : keyList) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
