#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/26 16:47
# @Author  : bearyang
# @Site    : 
# @File    : CustomSortString.py
# @Software: PyCharm
# Leetcode: 791. Custom Sort String
# https://leetcode.com/problems/custom-sort-string/description/


class Solution:
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        listT = list(T)
        length = len(listT)
        flag = True
        for i in range(length):
            if not flag:
                break
            flag = False
            for j in range(length - i - 1):
                if listT[j] in S:
                    if listT[j + 1] not in S or S.index(listT[j]) > S.index(listT[j + 1]):
                        temp = listT[j]
                        listT[j] = listT[j + 1]
                        listT[j + 1] = temp
                        flag = True
        return ''.join(listT)


test = Solution()
S = 'cba'
T = 'abcfde'
print(test.customSortString(S, T))