#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/9 15:03
# @Author  : bearyang
# @Site    : 
# @File    : UniquePathsWithObstacles.py
# @Software: PyCharm

# 115. 不同的路径 II
# http://www.lintcode.com/zh-cn/problem/unique-paths-ii/


class Solution:
    """
    @param: obstacleGrid: A list of lists of integers
    @return: An integer
    """

    def uniquePathsWithObstacles(self, obstacleGrid):
        if not obstacleGrid or len(obstacleGrid) == 0 or len(obstacleGrid[0]) == 0:
            return 0
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        # 初始化paths
        paths = []
        for i in range(0, m):
            temp = []
            for j in range(0, n):
                temp.append(0)
            paths.append(temp)
        paths[0][0] = 1

        for j in range(1, n):
            if obstacleGrid[0][j] == 1:
                paths[0][j] = 0
            else:
                paths[0][j] = paths[0][j - 1]

        for i in range(1, m):
            if obstacleGrid[i][0] == 1:
                paths[i][0] = 0
            else:
                paths[i][0] = paths[i - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    paths[i][j] = 0
                else:
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
        return paths[m - 1][n - 1]


test = Solution()
grids = [[0, 0, 0], [0, 0, 1], [0, 0, 0], [0, 0, 0]]
print(test.uniquePathsWithObstacles(grids))
