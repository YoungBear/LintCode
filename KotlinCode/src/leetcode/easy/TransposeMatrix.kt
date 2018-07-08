package leetcode.easy

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/7/8 21:31
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 矩阵的转置
 * Leetcode 868. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 */
class TransposeMatrix {
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        val B = Array(A[0].size) { IntArray(A.size) }
        for (i in B.indices) {
            for (j in 0 until B[i].size) {
                B[i][j] = A[j][i]
            }
        }
        return B
    }
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val test = TransposeMatrix()

            val A = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
            test.printMatrix(A)
            println("----------------")
            val B = test.transpose(A)
            test.printMatrix(B)

            val A2 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
            test.printMatrix(A2)
            println("----------------")
            val B2 = test.transpose(A2)
            test.printMatrix(B2)
        }
    }


    fun printMatrix(A: Array<IntArray>) {
        for (i in A.indices) {
            for (j in 0 until A[i].size) {
                print(A[i][j].toString() + " ")
            }
            println()
        }
    }
}