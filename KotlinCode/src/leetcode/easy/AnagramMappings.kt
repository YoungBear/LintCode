package leetcode.easy

/**
 * 760. Find Anagram Mappings
 * https://leetcode.com/problems/find-anagram-mappings/description/
 */
class AnagramMappings {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {
        val len = A.size
        val result: IntArray = IntArray(len)
        for (i in 0 until len) {
            for (j in 0 until len) {
                if (A[i] == B[j]) {
                    result[i] = j
                    break
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val test = AnagramMappings()
    val arrA = intArrayOf(12, 28, 46, 32, 50)
    val arrB = intArrayOf(50, 12, 32, 46, 28)
    val result = test.anagramMappings(arrA, arrB)
    for (i in result) {
        println(i)
    }
}