#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 9:50
# @Author  : bearyang
# @Site    : 
# @File    : MergeSortedArray.py
# @Software: PyCharm
# Lintcode 64. 合并排序数组
# http://www.lintcode.com/zh-cn/problem/merge-sorted-array/


class Solution:
    """
    @param: A: sorted integer array A which has m elements, but size of A is m+n
    @param: m: An integer
    @param: B: sorted integer array B which has n elements
    @param: n: An integer
    @return: nothing
    """

    def mergeSortedArray(self, A, m, B, n):
        temp = []
        i = 0
        j = 0
        while i < m and j < n:
            if A[i] > B[j]:
                temp.append(B[j])
                j += 1
            else:
                temp.append(A[i])
                i += 1
        while i < m:
            temp.append(A[i])
            i += 1
        while j < n:
            temp.append(B[j])
            j += 1
        for i in range(0, m + n):
            A[i] = temp[i]


test = Solution()
A = [1, 2, 3, -1, -1]
m = 3
B = [4, 5]
n = 2
test.mergeSortedArray(A, m, B, n)
for i in range(0, m + n):
    print(A[i])
