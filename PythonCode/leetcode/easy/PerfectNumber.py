#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/28 14:36
# @Author  : bearyang
# @Site    : 
# @File    : PerfectNumber.py
# @Software: PyCharm
# Leetcode 507. Perfect Number
# https://leetcode.com/problems/perfect-number/description/


import math
class Solution:
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 1:
            return False

        sum = 1
        for i in range(2, int(math.sqrt(num)) + 1):
            if (num % i) == 0:
                sum += i
                if num / i != i:
                    sum += int(num / i)

        return num == sum


test = Solution()
for i in range(1, 1000):
    if test.checkPerfectNumber(i):
        print(i)
# print(test.checkPerfectNumber(28))