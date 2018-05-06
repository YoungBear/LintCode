#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/5/6 18:19
# @Author  : youngbear
# @Email   : youngbear@aliyun.com
# @Blog    : https://blog.csdn.net/next_second
# @Github  : https://github.com/YoungBear
# @File    : SubMainVisits.py
# @Software: PyCharm
# Leetcode 811. Subdomain Visit Count
# https://leetcode.com/problems/subdomain-visit-count/description/


class Solution:
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        time_map = {}
        for cpdomain in cpdomains:
            strings = cpdomain.split(" ")
            times = int(strings[0])
            domains = strings[1].split(".")
            start_index = 0
            for i in range(len(domains)):
                if i > 0:
                    start_index += len(domains[i - 1]) + 1
                s = strings[1][start_index:]
                if s in time_map:
                    time_map[s] += times
                else:
                    time_map[s] = times
        result_list = []
        for key in time_map.keys():
            item = str(time_map[key]) + " " + key
            result_list.append(item)
        return result_list


test = Solution()
cpdomains1 = ["9001 discuss.leetcode.com"]
print(test.subdomainVisits(cpdomains1))

cpdomains2 = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
print(test.subdomainVisits(cpdomains2))