#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/10 15:25
# @Author  : bearyang
# @Site    : 
# @File    : SearchMatrix.py
# @Software: PyCharm
# Lintcode 28. 搜索二维矩阵
# http://www.lintcode.com/zh-cn/problem/search-a-2d-matrix/

class Solution:
    """
    @param: matrix: matrix, a list of lists of integers
    @param: target: An integer
    @return: a boolean, indicate whether matrix contains target
    """

    def searchMatrix(self, matrix, target):
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        if target < matrix[0][0] or target > matrix[m - 1][n - 1]:
            return False

        index = 0
        for i in range(m):
            if matrix[i][n - 1] >= target:
                index = i
                break
        for j in range(n):
            if matrix[index][j] == target:
                return True
        return False


test = Solution()
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
target = 3
print(test.searchMatrix(matrix, target))
