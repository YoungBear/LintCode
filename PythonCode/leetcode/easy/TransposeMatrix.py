#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/7/8 21:38
# @Author  : youngbear
# @Email   : youngbear@aliyun.com
# @Blog    : https://blog.csdn.net/next_second
# @Github  : https://github.com/YoungBear
# @File    : TransposeMatrix.py
# @Software: PyCharm
# @Description : 矩阵的转置
# Leetcode 868. Transpose Matrix
# https://leetcode.com/problems/transpose-matrix/description/

class Solution:
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        B = []
        for i in range(len(A[0])):
            temp = []
            for j in range(len(A)):
                temp.append(A[j][i])
            B.append(temp)
        return B


test = Solution()
A1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(A1)
print(test.transpose(A1))

A2 = [[1, 2, 3], [4, 5, 6]]
print(A2)
print(test.transpose(A2))
