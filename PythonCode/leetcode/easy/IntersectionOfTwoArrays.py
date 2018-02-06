#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/6 15:22
# @Author  : bearyang
# @Site    : 
# @File    : IntersectionOfTwoArrays.py
# @Software: PyCharm
# 349. Intersection of Two Arrays
# https://leetcode.com/problems/intersection-of-two-arrays/description/


class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        # 先去掉nums1和nums2中的重复元素，存为temp1和temp2
        temp1 = []
        len1 = len(nums1)
        for i in range(len1):
            if nums1[i] not in temp1:
                temp1.append(nums1[i])

        temp2 = []
        len2 = len(nums2)
        for i in range(len2):
            if nums2[i] not in temp2:
                temp2.append(nums2[i])

        result = []
        len2 = len(temp2)
        for i in range(len2):
            if temp2[i] in temp1:
                result.append(temp2[i])
        return result


test = Solution()
arrA = [1, 2, 2, 1]
arrB = [2, 2]
result = test.intersection(arrA, arrB)
for item in result:
    print(item)



