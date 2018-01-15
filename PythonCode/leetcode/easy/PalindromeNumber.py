#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/16 9:10
# @Author  : bearyang
# @Site    : 
# @File    : PalindromeNumber.py
# @Software: PyCharm


class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        注意：python3除运算的时候，需要取整，即int(p / 10)，否则结果默认为小数
        """
        if x < 0:
            return False
        p = x
        q = 0
        while p >= 10:
            q = q * 10 + p % 10
            p = int(p / 10)
        return q == int(x / 10) and p == x % 10


test = Solution()
print(test.isPalindrome(11))