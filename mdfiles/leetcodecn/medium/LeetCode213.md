# [LeetCode 213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)

## 1. 题目描述

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。**这个地方所有的房屋都围成一圈**，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

## 2. 思路

本题目是 [LeetCode 198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/) 的进阶版，区别是房屋的收尾相连。即不能同时偷收尾两个房间。所以，可以将问题分解:

可以先计算0-(n-1)的节点的值max1，再计算1-n的节点的值max2，选择max(max1, max2)即可。

**注意：**需要处理长度为1的情况。



## 3. java 代码

```java
    /**
     * 动态规划
     * 参考Leetcode198的方案，由于节点首尾相邻，所以不能同时选择第一个和最后一个节点
     * 思路：可以先计算0-(n-1)的节点的值max1，再计算1-n的节点的值max2，选择max(max1, max2)即可
     * 注意：需要处理长度为1的情况
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }
        int preMax = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        int max1 = curMax;
        preMax = 0;
        curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        int max2 = curMax;

        return Math.max(max1, max2);
    }
```



