package lintcode.medium

import java.util.*

/**
 * 761. Smallest Subset
 * http://www.lintcode.com/zh-cn/problem/smallest-subset/
 */
class SmallestSubset {
    fun minElements(nums: IntArray): Int {
        Arrays.sort(nums)
        var sum = 0
        for (item in nums){
            sum += item
        }
        val lenA = nums.size
        var curSum = 0
        for (i in lenA - 1 downTo 0) {
            if (curSum > sum - curSum) {
                return lenA - i - 1
            } else {
                curSum += nums[i]
            }
        }
        return 0
    }

}

fun main(args: Array<String>) {
    val test = SmallestSubset()
    val arrA = intArrayOf(3,1,7,1)
    val arrB = intArrayOf(2,1,2)
    println(test.minElements(arrA))
    println(test.minElements(arrB))
}