#!/usr/bin/python3
# -*- coding: utf-8 -*-

# @Time    : 2018/3/19 15:05
# @Author  : bearyang
# @Site    : 
# @File    : MeetingRooms.py
# @Software: PyCharm
# Lintcode 920. Meeting Rooms
# http://www.lintcode.com/zh-cn/problem/meeting-rooms/


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: if a person could attend all meetings
    按照start从小到大排序，然后判断相邻两个的start和end大小
    """
    def canAttendMeetings(self, intervals):
        intervals.sort(key=lambda obj: obj.start)
        if len(intervals) <= 1:
            return True
        for i in range(1, len(intervals)):
            if intervals[i - 1].end > intervals[i].start:
                return False
        return True


test = Solution()
intervals = [Interval(0, 30), Interval(15, 20), Interval(5, 10)]
print(test.canAttendMeetings(intervals))