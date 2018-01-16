### [LeetCode 746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/description/)

**题目描述:**

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

**Example 1:**

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

**Example 2:**

```
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
```

**Note:**
1. cost will have a length in the range [2, 1000].
2. Every cost[i] will be an integer in the range [0, 999].

**简单的翻译下：**

有一个楼梯，每次可以走1层或者2层，cost数组表示每一层所需要花费的值。可以从第一层或者第二层开始。求，到达顶端所花费大的最小的值。

**思路：**

这是一个**动态规划(Dynamic programming, DP)**的问题。

如果我们用一个数组dp[]来存放到达每一层所需要的花费值。则则最终结果是求dp[cost.length]的值。因为每次可以走1层或者2层，并且可以从0或者从1开始，所以可以得到dp[0]为0，dp[1]为0。从2开始，dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，而这i-2和i-1层所要花费的值分别为cost[i-2]和cost[i-1]，所以，`dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])`。该算法的空间复杂度为**O(n)**，时间复杂度为**O(n)**。

具体的Java代码为：

```
    /**
     * @param cost 每一步所要花费的值
     * @return 到达顶部总共需要的值
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length - 1];
    }
```

由于在i大于等于2的情况下，dp[i]只跟dp[i-1]和dp[i-2]接cost数组有关。所以我们只需要用三个变量来存储结果即可， 即`dp0,dp1,dp2`，这样的空间复杂度就变成了**O(1)**。

最终的代码为：

```
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }
```

对应**Python3**代码为：

```
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        dp0, dp1, dp2 = 0, 0, 0
        for i in range(2, len(cost) + 1):
            dp2 = min(dp0 + cost[i - 2], dp1 + cost[i - 1])
            dp0,dp1 = dp1,dp2
        return dp2
```

对应**Kotlin**代码为：

```
    fun minCostClimbingStairs(cost: IntArray): Int {
        var dp0 = 0
        var dp1 = 0
        var dp2 = 0

        val length : Int = cost.size + 1
        for (index in 2 until length) {
            dp2 = min(dp0 + cost[index - 2], dp1 + cost[index - 1])
            dp0 = dp1
            dp1 = dp2
        }
        return dp2
    }
```
