package leetcode.easy

/**
 * 762. Prime Number of Set Bits in Binary Representation
 *
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 */
class Solution {
    private val PRIME_LIST = listOf<Int>(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

    fun countPrimeSetBits(L: Int, R: Int): Int {
        var i = L
        var result = 0
        while (i <= R) {
            if (PRIME_LIST.contains(count1(i))) {
                result++
            }
            i++
        }
        return result
    }

    /**
     * 计算n使用二进制表示的时候，1的个数
     */
    fun count1(n: Int): Int {
        var num = n
        var result = 0
        while (num > 0) {
            result += num % 2
            num /= 2
        }
        return result
    }
}

fun main(args: Array<String>) {
    val test = Solution();
    println(test.countPrimeSetBits(6, 10))
    println(test.countPrimeSetBits(10, 15))
}