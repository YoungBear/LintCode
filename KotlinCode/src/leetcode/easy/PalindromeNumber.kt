package leetcode.easy

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var p: Int = x
        var q = 0

        while (p >= 10) {
            q = q * 10 + p % 10
            p /= 10
        }
        return q == x / 10 && p == x % 10
    }
}