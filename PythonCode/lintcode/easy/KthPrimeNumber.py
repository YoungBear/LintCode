#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/8 9:48
# @Author  : bearyang
# @Site    : 
# @File    : KthPrimeNumber.py
# @Software: PyCharm

import math
class Solution:
    def kthPrime(self, n):
        index = 0
        for i in range(2, n+1):
            if self.isPrime(i):
                index += 1
        return index


    def isPrime(self, n):
        """
        判断一个数是否为素数
        :param n:
        :return:
        """
        if n == 0 or n == 1:
            return False
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
        return True


test = Solution()
print(test.kthPrime(2))
print(test.kthPrime(3))
print(test.kthPrime(5))
print(test.kthPrime(7))
print(test.kthPrime(11))