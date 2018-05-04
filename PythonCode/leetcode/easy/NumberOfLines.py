#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/5/1 22:35
# @Author  : youngbear
# @Email   : youngbear@aliyun.com
# @Blog    : https://blog.csdn.net/next_second
# @Github  : https://github.com/YoungBear
# @File    : NumberOfLines.py
# @Software: PyCharm
# Leetcode 806. Number of Lines To Write String
# https://leetcode.com/problems/number-of-lines-to-write-string/description/


class Solution:
    LINE_SIZE = 100

    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        result = [0,0]
        current_width = 0
        for ch in S:
            w = widths[ord(ch) - ord('a')]
            if current_width + w > self.LINE_SIZE:
                result[0] += 1
                current_width = w
            else:
                current_width += w

        result[0] += 1
        result[1] = current_width
        return result


test = Solution()
widths1 = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S1 = "abcdefghijklmnopqrstuvwxyz"
print(test.numberOfLines(widths1, S1))

widths2 = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S2 = "bbbcccdddaaa"
print(test.numberOfLines(widths2, S2))

