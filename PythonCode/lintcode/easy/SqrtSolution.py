#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/10 16:22
# @Author  : bearyang
# @Site    : 
# @File    : SqrtSolution.py
# @Software: PyCharm
# 141. x的平方根
# http://www.lintcode.com/zh-cn/problem/sqrtx/


class Solution:
    """
    @param: x: An integer
    @return: The sqrt of x
    """
    def sqrt(self, x):
        if x == 0:
            return 0
        begin = 1
        end = x
        middle = (begin + end) / 2
        while begin <= end:
            if x / int(middle) == int(middle):
                return int(middle)
            elif x / int(middle) > int(middle):
                begin = int(middle) + 1
            else:
                end = int(middle) - 1
            middle = (begin + end) / 2
        return int(middle)


test = Solution()
print(test.sqrt(3))
print(test.sqrt(8))
print(test.sqrt(9))
print(test.sqrt(11))