package leetcode.easy

import java.util.*

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/10 22:07
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 830. Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */
class LargeGroupPositions {

    fun largeGroupPositions(S: String): List<List<Int>> {
        val resultList = ArrayList<List<Int>>()
        var i = 0
        while (i < S.length) {
            val ch = S[i]
            var j = i + 1
            while (j < S.length && S[j] == ch) {
                j++
            }
            if (j - i >= LARGE_SIZE) {
                val list = ArrayList<Int>()
                list.add(i)
                list.add(j - 1)
                resultList.add(list)
                i = j - 1
            }
            i++
        }
        return resultList
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val test = LargeGroupPositions()
            val S1 = "abbxxxxzzy"
            val S2 = "abc"
            val S3 = "abcdddeeeeaabbbcd"
            test.largeGroupPositions(S1)
            test.largeGroupPositions(S2)
            test.largeGroupPositions(S3)

        }

        private val LARGE_SIZE = 3
    }
}