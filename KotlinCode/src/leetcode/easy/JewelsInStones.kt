package leetcode.easy

/**
 * Leetcode 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
class JewelsInStones{
    fun numJewelsInStones(J: String, S: String): Int {
        var count:Int = 0
        for (chJ in J) {
            for (chS in S) {
                if (chJ == chS) {
                    count++
                }
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val test = JewelsInStones()
    println(test.numJewelsInStones("aA", "aAAbbbb"))
    println(test.numJewelsInStones("z", "ZZ"))
}