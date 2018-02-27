package leetcode.easy
/**
 * Leetcode 788. Rotated Digits
 * https://leetcode.com/problems/rotated-digits/description/
 */
class RotatedDigits {
    fun rotatedDigits(N: Int): Int {
        var sum = 0
        for (i in 1..N) {
            if (isGoodDigit(i)) {
                sum++
            }
        }
        return sum
    }

    fun isGoodDigit(n: Int): Boolean {
        var t: Int = n
        var flag: Boolean = false
        while (t > 0) {
            val remainder = t % 10
            if (3 == remainder || 4 == remainder || 7 == remainder) {
                return false
            } else if (2 == remainder || 5 == remainder || 6 == remainder || 9 == remainder) {
                flag = true
            }
            t /= 10
        }
        return flag
    }
}

fun main(args: Array<String>) {
    val test = RotatedDigits()
    print(test.rotatedDigits(10))
}