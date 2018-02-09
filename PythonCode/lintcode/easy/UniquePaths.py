#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/9 11:07
# @Author  : bearyang
# @Site    : 
# @File    : UniquePaths.py
# @Software: PyCharm
# 114. 不同的路径
# http://www.lintcode.com/zh-cn/problem/unique-paths/


class Solution:
    """
    @param: m: positive integer (1 <= m <= 100)
    @param: n: positive integer (1 <= n <= 100)
    @return: An integer
    """
    def uniquePaths(self, m, n):
        nums = []
        for i in range(m):
            temps = []
            for j in range(n):
                if i == 0 or j == 0:
                    temps.append(1)
                else:
                    temps.append(0)
            nums.append(temps)
        for i in range(1, m):
            for j in range(1, n):
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1]
        return nums[m - 1][n - 1]


test = Solution()
print(test.uniquePaths(3, 3))
print(test.uniquePaths(4, 5))
