#!/usr/bin/python3
# -*- coding: utf-8 -*-
# Leetcode 788. Rotated Digits
# https://leetcode.com/problems/rotated-digits/description/


class Solution:
    def rotatedDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        sum = 0
        for i in range(1, N+1):
            if self.isGoodDigit(i):
                sum += 1
        return sum

    def isGoodDigit(self, n):
        """
        :param n:
        :return:
        """
        t = n
        flag = False
        while t > 0:
            remainder = t % 10
            if 3 == remainder or 4 == remainder or 7 == remainder:
                return False
            elif 2 == remainder or 5 == remainder or 6 == remainder or 9 == remainder:
                flag = True
            t = int(t / 10)
        return flag


test = Solution()
print(test.rotatedDigits(30))