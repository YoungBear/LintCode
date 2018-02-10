#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/2/10 9:26
# @Author  : bearyang
# @Site    : 
# @File    : JewelsInStones.py
# @Software: PyCharm


class Solution:
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        count = 0
        for chJ in J:
            for chS in S:
                if chJ == chS:
                    count += 1
        return count


test = Solution()
print(test.numJewelsInStones("aA", "aAAbbbb"))
print(test.numJewelsInStones("z", "ZZ"))