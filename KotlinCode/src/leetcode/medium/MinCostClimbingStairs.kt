package leetcode.medium

import kotlin.math.min

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
class MinCostClimbingStairs {

    /**
     * 使用min在网站上编译失败，故使用if-else
     */
    fun minCostClimbingStairs(cost: IntArray): Int {
        var dp0 = 0
        var dp1 = 0
        var dp2 = 0

        val length : Int = cost.size + 1
        for (index in 2 until length) {
            if (dp0 + cost[index -2] < dp1 + cost[index - 1]) {
                dp2 = dp0 + cost[index -2]
            } else {
                dp2 = dp1 + cost[index - 1]
            }
//            dp2 = min(dp0 + cost[index - 2], dp1 + cost[index - 1])
            dp0 = dp1
            dp1 = dp2
        }
        return dp2
    }

    fun minCostClimbingStairs2(cost: IntArray): Int {
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
}

fun main(args: Array<String>) {
    var test = MinCostClimbingStairs();
    var list1 : IntArray = intArrayOf(10, 15, 20)
    println(test.minCostClimbingStairs2(list1))

}