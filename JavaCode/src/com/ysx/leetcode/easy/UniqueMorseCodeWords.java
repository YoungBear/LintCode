package com.ysx.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/4/24 11:10
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */

public class UniqueMorseCodeWords {
    public static final Map<Character, String> LETTER_MAP = new HashMap<>();

    static {
        LETTER_MAP.put('a', ".-");
        LETTER_MAP.put('b', "-...");
        LETTER_MAP.put('c', "-.-.");
        LETTER_MAP.put('d', "-..");
        LETTER_MAP.put('e', ".");
        LETTER_MAP.put('f', "..-.");
        LETTER_MAP.put('g', "--.");
        LETTER_MAP.put('h', "....");
        LETTER_MAP.put('i', "..");
        LETTER_MAP.put('j', ".---");
        LETTER_MAP.put('k', "-.-");
        LETTER_MAP.put('l', ".-..");
        LETTER_MAP.put('m', "--");
        LETTER_MAP.put('n', "-.");
        LETTER_MAP.put('o', "---");
        LETTER_MAP.put('p', ".--.");
        LETTER_MAP.put('q', "--.-");
        LETTER_MAP.put('r', ".-.");
        LETTER_MAP.put('s', "...");
        LETTER_MAP.put('t', "-");
        LETTER_MAP.put('u', "..-");
        LETTER_MAP.put('v', "...-");
        LETTER_MAP.put('w', ".--");
        LETTER_MAP.put('x', "-..-");
        LETTER_MAP.put('y', "-.--");
        LETTER_MAP.put('z', "--..");
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords test = new UniqueMorseCodeWords();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(test.uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String item : words) {
            StringBuilder sb = new StringBuilder();
            for(char ch : item.toCharArray()) {
                sb.append(LETTER_MAP.get(ch));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
