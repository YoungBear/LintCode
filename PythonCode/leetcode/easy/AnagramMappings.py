#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/16 19:28
# @Author  : bearyang
# @Site    : 
# @File    : AnagramMappings.py
# @Software: PyCharm
# 760. Find Anagram Mappings
# https://leetcode.com/problems/find-anagram-mappings/description/


class Solution:
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        lenA = len(A)
        result = []
        for i in range(lenA):
            for j in range(lenA):
                if A[i] == B[j]:
                    result.append(j)
                    break

        return result


test = Solution()
arrA = [12, 28, 46, 32, 50]
arrB = [50, 12, 32, 46, 28]
result = test.anagramMappings(arrA, arrB)
for item in result:
    print(item)
