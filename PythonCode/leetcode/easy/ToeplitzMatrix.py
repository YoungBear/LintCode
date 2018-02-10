#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/10 11:34
# @Author  : bearyang
# @Site    : 
# @File    : ToeplitzMatrix.py
# @Software: PyCharm


class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            value = matrix[i][0]
            j = 1
            while i + j < m and j < n:
                if value != matrix[i + j][j]:
                    return False
                j += 1

        for j in range(1, n):
            value = matrix[0][j]
            i = 1
            while i < m and i + j < n:
                if value != matrix[i][i + j]:
                    return False
                i += 1
        return True


test = Solution()
matrix1 = [[1, 2, 3, 4], [5, 1, 2, 3], [9, 5, 1, 2]]
print(test.isToeplitzMatrix(matrix1))
matrix2 = [[1, 2], [2, 2]]
print(test.isToeplitzMatrix(matrix2))
matrix3 = [[65, 98, 57]]
print(test.isToeplitzMatrix(matrix3))
