package leetcode.easy

class ToeplitzMatrix {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        val m = matrix.size
        val n = matrix[0].size
        for (i in 0 until m) {
            val value = matrix[i][0]
            var j = 1
            while (j + i < m && j < n) {
                if (matrix[i + j][j] != value) {
                    return false
                }
                j++
            }
        }
        for (j in 1 until n) {
            val value = matrix[0][j]
            var i = 1
            while (i < m && i + j < n) {
                if (matrix[i][i + j] != value) {
                    return false
                }
                i++
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val test = ToeplitzMatrix()
    val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 1, 2, 3), intArrayOf(9, 5, 1, 2))
    println(test.isToeplitzMatrix(matrix))

    val matrix2 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 2))
    println(test.isToeplitzMatrix(matrix2))

    val matrix3 = arrayOf(intArrayOf(65, 98, 57))
    println(test.isToeplitzMatrix(matrix3))
}