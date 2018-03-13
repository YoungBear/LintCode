package leetcode.easy

/**
 * Leetcode 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 */
class RotateString{
    fun rotateString(A: String, B: String): Boolean {
        return A.length == B.length && (A + A).contains(B)
    }

    fun rotateString_old(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }
        val length:Int = A.length
        for (i in 0 until length) {
            val sub1:String = A.substring(0, i)
            val sub2:String = A.substring(i)
            val temp:String = sub2 + sub1
            if (temp == B) {
                return true
            }
        }
        return false
    }
}

fun main(args: Array<String>) {
    val test = RotateString()
    val A1:String = "abcde"
    val B1:String = "cdeab"
    println(test.rotateString(A1, B1))

    val A2:String = "abcde"
    val B2:String = "abced"
    println(test.rotateString(A2, B2))
}