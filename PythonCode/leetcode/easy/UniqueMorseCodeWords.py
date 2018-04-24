#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/4/24 11:13
# @Author  : youngbear
# @Email   : youngbear@aliyun.com
# @Blog    : https://blog.csdn.net/next_second
# @Github  : https://github.com/YoungBear
# @File    : UniqueMorseCodeWords.py
# @Software: PyCharm
# Leetcode 804. Unique Morse Code Words
# https://leetcode.com/problems/unique-morse-code-words/description/


class Solution:
    LETTER_MAP = {
        'a': ".-",
        'b': "-...",
        'c': "-.-.",
        'd': "-..",
        'e': ".",
        'f': "..-.",
        'g': "--.",
        'h': "....",
        'i': "..",
        'j': ".---",
        'k': "-.-",
        'l': ".-..",
        'm': "--",
        'n': "-.",
        'o': "---",
        'p': ".--.",
        'q': "--.-",
        'r': ".-.",
        's': "...",
        't': "-",
        'u': "..-",
        'v': "...-",
        'w': ".--",
        'x': "-..-",
        'y': "-.--",
        'z': "--.."
    }

    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        set1 = set()
        for word in words:
            str = ""
            for ch in word:
                str += self.LETTER_MAP.get(ch)
            set1.add(str)
        return len(set1)


test = Solution()
words = ["gin", "zen", "gig", "msg"]
print(test.uniqueMorseRepresentations(words))