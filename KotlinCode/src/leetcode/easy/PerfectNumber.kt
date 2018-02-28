package leetcode.easy

/**
 * Leetcode 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/description/
 */
class PerfectNumber {
    fun checkPerfectNumber(num: Int): Boolean {
        if (num <= 1) {
            return false
        }
        var sum:Int = 1
        for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                sum += i
                if (num / i != i) {
                    sum += num / i
                }
            }
        }
        return num == sum
    }
}

fun main(args: Array<String>) {
    val test = PerfectNumber()
    print(test.checkPerfectNumber(28))
}