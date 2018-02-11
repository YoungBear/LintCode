#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 11:43
# @Author  : bearyang
# @Site    : 
# @File    : SearchInsert.py
# @Software: PyCharm
# Lintcode 60. 搜索插入位置
# http://www.lintcode.com/zh-cn/problem/search-insert-position/


class Solution:
    """
    @param: A: an integer sorted array
    @param: target: an integer to be inserted
    @return: An integer
    """

    def searchInsert(self, A, target):
        for i in range(len(A)):
            if A[i] >= target:
                return i
        return len(A)


test = Solution()
A = [1, 3, 5, 6]
target1 = 5
target2 = 2
target3 = 7
target4 = 0
print(test.searchInsert(A, target1))
print(test.searchInsert(A, target2))
print(test.searchInsert(A, target3))
print(test.searchInsert(A, target4))
