package leetcode.easy

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/1 14:38
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 806. Number of Lines To Write String
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 */
class NumberOfLines {

    fun numberOfLines(widths: IntArray, S: String): IntArray {
        val result = IntArray(2)
        val chars = S.toCharArray()
        var currentWidth = 0
        for (i in chars.indices) {
            val w = widths[chars[i] - 'a']
            if (currentWidth + w > LINE_SIZE) {
                result[0]++
                currentWidth = w
            } else {
                currentWidth += w
            }
        }
        result[0] += 1
        result[1] = currentWidth
        println(result[0])
        println(result[1])
        return result
    }

    companion object {

        private val LINE_SIZE = 100

        @JvmStatic
        fun main(args: Array<String>) {
            val test = NumberOfLines()
            val widths = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
            val S = "abcdefghijklmnopqrstuvwxyz"
            test.numberOfLines(widths, S)

            val widths1 = intArrayOf(4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
            val S1 = "bbbcccdddaaa"
            test.numberOfLines(widths1, S1)

        }
    }
}