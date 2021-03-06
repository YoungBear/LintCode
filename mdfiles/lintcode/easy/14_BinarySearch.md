### [14. 二分查找](http://www.lintcode.com/zh-cn/problem/first-position-of-target/)

**题目描述：**

给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target<font color=red>**第一次**</font>出现的下标（从0开始），如果target不存在于数组中，返回-1。

**思路：**

使用二分法，查找指定元素。然后在找到最左边的那个元素，即第一次出现的元素。

```
    public int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int begin = 0;
        int end = len - 1;
        int middle = (begin + end) / 2;
        while (begin <= end) {
            if (target > nums[middle]) {
                begin = middle + 1;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                // 找到第一个出现的元素
                while (middle >= 0 && nums[middle] == target) {
                    middle--;
                }
                return middle + 1;
            }
            middle = (begin + end) / 2;
        }
        return -1;
    }
```