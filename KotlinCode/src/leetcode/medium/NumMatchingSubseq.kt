package leetcode.medium


/**
 * Leetcode 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 */
class NumMatchingSubseq {
    fun numMatchingSubseq(S: String, words: Array<String>): Int {
        var num:Int = 0
        val lengthS:Int = S.length
        for (word:String in words) {
            val lengthWord:Int = word.length
            var flag:Boolean = false
            var i:Int = 0
            var j:Int = 0
            while (i < lengthS && j < lengthWord){
                if (S.get(i) == word.get(j)) {
                    i++
                    j++
                    flag = true
                } else {
                    i++
                    flag = false
                }
            }
            if (j == lengthWord && flag) {
                num++
            }
        }
        return num
    }
}

fun main(args: Array<String>) {
    val test = NumMatchingSubseq()
    val S:String = "abcde"
    val words:Array<String> = arrayOf("a", "bb", "acd", "ace")
    for (word:String in words) {
        println(word)
    }
    print(test.numMatchingSubseq(S, words))
}