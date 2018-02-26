package leetcode.medium

/**
 * Leetcode: 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/description/
 */
class Solution {
    fun customSortString(S: String, T: String): String {
        val arrayT = T.toCharArray()
        var flag : Boolean = true
        val size = arrayT.size
        for (i in 0 until size){
            if (!flag) {
                break
            }
            flag = false
            for (j in 0 until size - i - 1) {
                if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                    val temp:Char = arrayT[j]
                    arrayT[j] = arrayT[j + 1]
                    arrayT[j + 1] = temp
                    flag = true
                }
            }
        }
        return String(arrayT)
    }
}

fun main(args: Array<String>) {
    val test = Solution()
    val S = "cba"
    val T = "abcd"
    println(test.customSortString(S, T))
}
