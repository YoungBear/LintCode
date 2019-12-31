# [LeetCode 198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

## 1. 题目描述

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

## 2. 思路



动态规划，使用数组int[] dp，其中：

- dp[i] 表示前i个节点的最优解
- dp[i] = max(dp[i-1], dp[i-2] + A[i])

即 当 i >= 2时，dp[i]可以取两种情况，一种是不取i节点的值，而使用dp[i-1]；另一种是取i节点的值，加上dp[i-2]。A[i] 表示i节点的值。



## 3. Java 代码

```java
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (1 == nums.length) {
            return dp[0];
        }
        dp[1] = Math.max(dp[0], nums[1]);
        if (2 == nums.length) {
            return dp[1];
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
```

优化：dp数组可以优化为两个变量，用来表示前两步步取值。

优化后的代码：

```java
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int n : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + n);
            preMax = temp;
        }
        return curMax;
    }
```

