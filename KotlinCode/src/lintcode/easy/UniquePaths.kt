package lintcode.easy

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 0 || n == 0) {
            return 0
        }
        val nums = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 1
                } else {
                    nums[i][j] = 0
                }
            }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1]
            }
        }
        return nums[m - 1][n - 1]
    }
}

fun main(args: Array<String>) {
    val test = UniquePaths()
    println(test.uniquePaths(3, 3))
    println(test.uniquePaths(4, 5))

}