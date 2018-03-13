#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/3/13 9:32
# @Author  : bearyang
# @Site    : 
# @File    : RotateString.py
# @Software: PyCharm
# Leetcode 796. Rotate String
# https://leetcode.com/problems/rotate-string/description/


class Solution:

    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        return len(A) == len(B) and B in (A + A)

    def rotateString_old(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if len(A) != len(B):
            return False
        length = len(A)
        for i in range(length):
            sub1 = A[0:i]
            sub2 = A[i:length]
            temp = sub2 + sub1
            if temp == B:
                return True
        return False


test = Solution()
A1 = 'abcde'
B1 = 'cdeab'
print(test.rotateString(A1, B1))

A2 = 'abcde'
B2 = 'abced'
print(test.rotateString(A2, B2))
