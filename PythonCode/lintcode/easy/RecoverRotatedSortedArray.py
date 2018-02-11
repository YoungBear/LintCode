#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 11:04
# @Author  : bearyang
# @Site    : 
# @File    : RecoverRotatedSortedArray.py
# @Software: PyCharm
# Lintcode 39. 恢复旋转排序数组
# http://www.lintcode.com/zh-cn/problem/recover-rotated-sorted-array/


class Solution:
    """
    @param: nums: An integer array
    @return: nothing
    """

    def recoverRotatedSortedArray(self, nums):
        lenA = len(nums)
        t = -1
        for i in range(lenA - 1):
            if nums[i] > nums[i + 1]:
                t = i
                break
        temp = []
        for i in range(t + 1):
            temp.append(nums[i])
        for i in range(t + 1, lenA):
            nums[i - t - 1] = nums[i]
        for i in range(t + 1):
            nums[i + lenA - t - 1] = temp[i]


test = Solution()
nums = [4, 5, 1, 2, 3]
test.recoverRotatedSortedArray(nums)
for i in range(len(nums)):
    print(nums[i])
