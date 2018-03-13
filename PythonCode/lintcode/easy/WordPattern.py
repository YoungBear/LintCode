#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/3/13 14:19
# @Author  : bearyang
# @Site    : 
# @File    : WordPattern.py
# @Software: PyCharm
# Lintcode 828. Word Pattern
# http://www.lintcode.com/zh-cn/problem/word-pattern/
# Leetcode 290. Word Pattern
# https://leetcode.com/problems/word-pattern/description/


class Solution:
    """
    @param pattern: a string, denote pattern string
    @param str: a string, denote matching string
    @return: an boolean, denote whether the pattern string and the matching string match or not
    """
    def wordPattern(self, pattern, str):
        strArray = str.split(' ')
        if len(pattern) != len(strArray):
            return False
        length = len(pattern)
        map = {}
        for i in range(length):
            ch = pattern[i]
            if ch in map.keys():
                if map.get(ch) != strArray[i]:
                    return False
            else:
                if strArray[i] in map.values():
                    return False
                map[ch] = strArray[i]
        return True


test = Solution()
pattern1 = 'abba'
str1 = 'dog cat cat dog'
print(test.wordPattern(pattern1, str1))

pattern2 = 'abba'
str2 = 'dog dog dog dog'
print(test.wordPattern(pattern2, str2))
