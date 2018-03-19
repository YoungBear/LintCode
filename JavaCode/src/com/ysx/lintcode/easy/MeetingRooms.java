package com.ysx.lintcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Lintcode 920. Meeting Rooms
 * http://www.lintcode.com/zh-cn/problem/meeting-rooms/
 */
public class MeetingRooms {

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        MeetingRooms test = new MeetingRooms();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println(test.canAttendMeetings(intervals));
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) {
            return true;
        }
        // 按照start从小到大排序，然后判断相邻两个的start和end大小
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }
        return true;
    }
}
