#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/31 10:55
# @Author  : bearyang
# @Site    : 
# @File    : JohnGarden.py
# @Software: PyCharm
# 749. 约翰的后花园
# http://www.lintcode.com/zh-cn/problem/johns-backyard-garden/


class Solution:
    """
    @param x: the wall's height
    @return: YES or NO
    """
    def isBuild(self, x):
        value_x = 3
        value_y = 7
        i = 0
        while value_x * i <= x:
            t = x - value_x * i
            k = int(t/value_y)
            if value_y * k == t:
                return "YES"
            i += 1
        return "NO"

test = Solution()
print("10: ", test.isBuild(10))
print("5: ", test.isBuild(5))
