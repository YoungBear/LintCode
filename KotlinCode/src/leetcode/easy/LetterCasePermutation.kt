package leetcode.easy

import java.util.ArrayList

/**
 * Leetcode 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
class LetterCasePermutation {
    fun letterCasePermutation(S: String): List<String> {
        val lowerStr = S.toLowerCase()
        val builderList = ArrayList<StringBuilder>()
        builderList.add(StringBuilder(""))
        val chars = lowerStr.toCharArray()
        for (ch in chars) {
            if (Character.isDigit(ch)) {
                for (stringBuilder in builderList) {
                    stringBuilder.append(ch)
                }
            } else {
                val size = builderList.size
                var j = 0
                while (j < 2 * size) {
                    val temp = builderList[j].toString()
                    builderList[j].append(ch)
                    builderList.add(j + 1, StringBuilder(temp + Character.toUpperCase(ch)))
                    j += 2
                }
            }
        }
        val resultList = ArrayList<String>()
        for (stringBuilder in builderList) {
            resultList.add(stringBuilder.toString())
        }
        return resultList
    }
}

fun main(args: Array<String>) {
    val test = LetterCasePermutation()
    val S = "a1b2"
    val list = test.letterCasePermutation(S)
    for (item in list) {
        println(item)
    }
}