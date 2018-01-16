#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/16 15:40
# @Author  : bearyang
# @Site    : 
# @File    : CountPrimeSetBits.py
# @Software: PyCharm

# 762. Prime Number of Set Bits in Binary Representation
# https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/


class Solution:
    PRIME_LIST = (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

    def countPrimeSetBits(self, L, R):
        """
        :type L: int
        :type R: int
        :rtype: int
        """
        result = 0
        for i in range(L, R + 1):
            if self.count1(i) in self.PRIME_LIST:
                result += 1
        return result

    def count1(self, n):
        """
        计算n使用二进制表示的时候，1的个数
        :param n:
        :return:
        """
        result = 0
        b = bin(n)
        for x in b:
            if x == '1':
                result += 1
        return result


test = Solution()
print(test.countPrimeSetBits(6, 10))
print(test.countPrimeSetBits(10, 15))
print(test.countPrimeSetBits(73604, 83069))