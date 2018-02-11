#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/11 14:51
# @Author  : bearyang
# @Site    : 
# @File    : RemoveDuplicates1.py
# @Software: PyCharm
# Lintcode 100. 删除排序数组中的重复数字
# http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-array/


class Solution:
    """
    @param: nums: An ineger array
    @return: An integer
    """

    def removeDuplicates(self, nums):
        i = 0
        while i < len(nums) - 1:
            if nums[i] == nums[i + 1]:
                nums.pop(i + 1)
            else:
                i += 1
        return len(nums)


test = Solution()
nums = [1, 1, 2, 2, 3]
print(test.removeDuplicates(nums))
print("*************")
for i in range(len(nums)):
    print(nums[i])
