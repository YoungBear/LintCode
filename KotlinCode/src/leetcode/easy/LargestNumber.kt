package leetcode.easy

class LargestNumber {
    fun dominantIndex(nums: IntArray): Int {
        val lenA = nums.size
        if (lenA < 1) {
            return -1
        } else if (lenA == 1) {
            return 0
        }
        var max = nums[0]
        var maxIndex = 0
        for (i in 1 until lenA) {
            if (nums[i] > max) {
                max = nums[i]
                maxIndex = i
            }
        }
        var second = 0
        if (maxIndex == 0) {
            second = nums[1]
        } else {
            second = nums[0]
        }
        for (i in 0 until lenA) {
            if (i == maxIndex) {
                continue
            }
            if (nums[i] > second) {
                second = nums[i]
            }
        }
        if (max >= 2 * second) {
            return maxIndex
        } else {
            return -1
        }
    }

}

fun main(args: Array<String>) {
    val test = LargestNumber()
    val arrA = intArrayOf(3, 6, 1, 0)
    val arrB = intArrayOf(1, 2, 3, 4)
    val arrC = intArrayOf(0, 0, 3, 2)
    println(test.dominantIndex(arrA))
    println(test.dominantIndex(arrB))
    println(test.dominantIndex(arrC))
}