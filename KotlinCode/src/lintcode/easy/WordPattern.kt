package lintcode.easy

import java.util.HashMap

class WordPattern{
    fun wordPattern(pattern: String, str: String): Boolean {
        val strArray = str.split(" ")
        if (pattern.length != strArray.size) {
            return false
        }
        val length = pattern.length
        val map = HashMap<Char, String>()
        for (i in 0 until length) {
            val ch = pattern[i]
            if (map.containsKey(ch)) {
                if (map[ch] != strArray[i]) {
                    return false
                }
            } else {
                if (map.containsValue(strArray[i])) {
                    return false
                }
                map[ch] = strArray[i]
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val test = WordPattern()
    val pattern1 = "abba"
    val str1 = "dog cat cat dog"
    println(test.wordPattern(pattern1, str1))

    val pattern2 = "abba"
    val str2 = "dog dog dog dog"
    println(test.wordPattern(pattern2, str2))
}