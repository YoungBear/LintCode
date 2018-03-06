#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/3/6 11:44
# @Author  : bearyang
# @Site    : 
# @File    : NumMatchingSubseq.py
# @Software: PyCharm
# Leetcode 792. Number of Matching Subsequences
# https://leetcode.com/problems/number-of-matching-subsequences/description/


class Solution:
    def numMatchingSubseq(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        num = 0
        length_s = len(S)
        for word in words:
            length_word = len(word)
            flag = False
            i = 0
            j = 0
            while i < length_s and j < length_word:
                if S[i] == word[j]:
                    i += 1
                    j += 1
                    flag = True
                else:
                    i += 1
                    flag = False
            if j == length_word and flag:
                num += 1
        return num


test = Solution()
S = 'abcde'
words = ['a', 'bb', 'acd', 'ace']
print(test.numMatchingSubseq(S, words))