#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 13:58
# @Author  : bearyang
# @Site    : 
# @File    : RemoveElement.py
# @Software: PyCharm
# Lintcode 172. 删除元素
# http://www.lintcode.com/zh-cn/problem/remove-element/


class Solution:
    """
    @param: A: A list of integers
    @param: elem: An integer
    @return: The new length after remove
    """

    def removeElement(self, A, elem):
        i = 0
        while i < len(A):
            if elem == A[i]:
                A.pop(i)
            else:
                i += 1
        return len(A)


test = Solution()
A = [0, 4, 4, 0, 0, 2, 4, 4]
elem = 4
print(test.removeElement(A, elem))
