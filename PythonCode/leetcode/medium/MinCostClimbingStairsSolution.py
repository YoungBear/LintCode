"""
746. Min Cost Climbing Stairs
https://leetcode.com/problems/min-cost-climbing-stairs/description/
"""
class Solution:
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

    def minCostClimbingStairs2(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        dp0 = 0
        dp1 = 0
        dp2 = 0
        for i in range(2, len(cost) + 1):
            dp2 = min(dp0 + cost[i - 2], dp1 + cost[i - 1])
            dp0 = dp1
            dp1 = dp2
        return dp2


# 测试

list1 = [10, 15, 20]
test = Solution()
print(test.minCostClimbingStairs(list1))