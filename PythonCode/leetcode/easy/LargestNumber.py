#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/1/18 18:16
# @Author  : bearyang
# @Site    : 
# @File    : LargestNumber.py
# @Software: PyCharm


class LargestNumber:


    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lenA = len(nums)
        if lenA < 1:
            return -1
        elif lenA == 1:
            return 0
        max = nums[0]
        maxIndex = 0
        for i in range(lenA):
            if nums[i] > max:
                max = nums[i]
                maxIndex = i
        second = 0
        if maxIndex == 0:
            second = nums[1]
        else:
            second = nums[0]
        for i in range(lenA):
            if i == maxIndex:
                continue
            if nums[i] > second:
                second = nums[i]

        if max >= 2 * second:
            return maxIndex
        else:
            return -1


test = LargestNumber()
arrA = [3, 6, 1, 0]
arrB = [1, 2, 3, 4]
arrC = [0, 0, 3, 2]
print(test.dominantIndex(arrA))
print(test.dominantIndex(arrB))
print(test.dominantIndex(arrC))
