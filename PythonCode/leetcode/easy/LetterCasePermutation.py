#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/28 11:25
# @Author  : bearyang
# @Site    : 
# @File    : LetterCasePermutation.py
# @Software: PyCharm
# Leetcode 784. Letter Case Permutation
# https://leetcode.com/problems/letter-case-permutation/description/


class Solution:
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        lowS = S.lower()
        resultList = ['']
        for ch in lowS:
            if ch.isdigit():
                for i in range(0, len(resultList)):
                    resultList[i] += ch
            else:
                size = len(resultList)
                for j in range(0, 2 * size, 2):
                    temp = resultList[j]
                    resultList[j] += ch
                    resultList.insert(j + 1, temp + ch.upper())
        return resultList


test = Solution()
S = 'a1b2'
resultList = test.letterCasePermutation(S)
for item in resultList:
    print(item)