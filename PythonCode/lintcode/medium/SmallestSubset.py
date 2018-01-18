#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/18 16:12
# @Author  : bearyang
# @Site    : 
# @File    : SmallestSubset.py
# @Software: PyCharm

# 761. Smallest Subset
# http://www.lintcode.com/zh-cn/problem/smallest-subset/

class Solution:
    def minElements(self, nums):
        """
        思路，先排序，计算出数组元素的和，然后从后往前遍历，累加元素，当累加的数大于剩余的数时，满足条件
        :param nums:
        :return:
        """
        nums.sort(reverse=True)
        sumA = sum(nums)
        num = 0
        curSum = 0
        for item in nums:
            if curSum > sumA - curSum:
                return num
            curSum += item
            num += 1


test = Solution()
arrA = [3, 1, 7, 1]
print(test.minElements(arrA))
arrB = [2, 2, 1]
print(test.minElements(arrB))
