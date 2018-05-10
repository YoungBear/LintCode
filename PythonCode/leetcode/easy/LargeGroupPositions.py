#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/5/10 22:11
# @Author  : youngbear
# @Email   : youngbear@aliyun.com
# @Blog    : https://blog.csdn.net/next_second
# @Github  : https://github.com/YoungBear
# @File    : LargeGroupPositions.py
# @Software: PyCharm
# Leetcode 830. Positions of Large Groups
# https://leetcode.com/problems/positions-of-large-groups/description/

class Solution:

    LARGE_SIZE = 3

    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        result_list = []
        i = 0
        while i < len(S):
            ch = S[i]
            j = i + 1
            while j < len(S) and S[j] == ch:
                j += 1
            if j - i >= self.LARGE_SIZE:
                item = [i, j - 1]
                result_list.append(item)
                i = j - 1
            i += 1
        return result_list


test = Solution()
S1 = "abbxxxxzzy"
S2 = "abc"
S3 = "abcdddeeeeaabbbcd"
print(test.largeGroupPositions(S1))
print(test.largeGroupPositions(S2))
print(test.largeGroupPositions(S3))