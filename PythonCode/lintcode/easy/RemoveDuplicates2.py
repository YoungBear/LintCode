#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 15:05
# @Author  : bearyang
# @Site    : 
# @File    : RemoveDuplicates2.py
# @Software: PyCharm
# 101. 删除排序数组中的重复数字 II
# http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-array-ii/
# 允许出现两次重复


class Solution:
    """
    @param: nums: An ineger array
    @return: An integer
    """
    def removeDuplicates(self, nums):
        i = 0
        while i < len(nums) - 1:
            if nums[i] == nums[i + 1]:
                j = i + 2
                while j < len(nums) and nums[i] == nums[j]:
                    nums.pop(j)
            i += 1
        return len(nums)


test = Solution()
nums = [1, 1, 2, 2, 3]
print(test.removeDuplicates(nums))
print("*************")
for i in range(len(nums)):
    print(nums[i])