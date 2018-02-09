package lintcode.easy

/**
 * 115. 不同的路径 II
 * http://www.lintcode.com/zh-cn/problem/unique-paths-ii/
 */
class UniquePathsWithObstacles {

    private val HAS_GRID: Int = 1
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) {
            return 0;
        }
        if (obstacleGrid[0][0] == HAS_GRID) {
            return 0;
        }
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val paths = Array(m) { IntArray(n) }
        paths[0][0] = 1
        for (j in 1 until n) {
            if (obstacleGrid[0][j] == HAS_GRID) {
                paths[0][j] = 0
            } else {
                paths[0][j] = paths[0][j - 1]
            }
        }
        for (i in 1 until m) {
            if (obstacleGrid[i][0] == HAS_GRID) {
                paths[i][0] = 0
            } else {
                paths[i][0] = paths[i - 1][0]
            }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (obstacleGrid[i][j] == HAS_GRID) {
                    paths[i][j] = 0
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
                }
            }
        }
        return paths[m - 1][n - 1]
    }
}

fun main(args: Array<String>) {
    val test = UniquePathsWithObstacles()
    val grids = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
    println(test.uniquePathsWithObstacles(grids))
}