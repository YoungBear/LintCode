### [LintCode 115. 不同的路径 II](http://www.lintcode.com/zh-cn/problem/unique-paths-ii/)

**相关问题：**

[LintCode 114. 不同的路径](https://github.com/YoungBear/LintCode/blob/master/mdfiles/lintcode/easy/114_UniquePaths.md)


**题目描述：**

["不同的路径"](https://github.com/YoungBear/LintCode/blob/master/mdfiles/lintcode/easy/114_UniquePaths.md) 的跟进问题：

现在考虑网格中有<font color=red>**障碍物**</font>，那样将会有多少条不同的路径？

网格中的障碍和空位置分别用 1 和 0 来表示。

```
**注意事项**
m 和 n 均不超过100
```

**样例：**

```
如下所示在3x3的网格中有一个障碍物：

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

一共有2条不同的路径从左上角到右下角。
```

### **思路：**

与上一个版本类似，这个问题我们只需要考虑有障碍的情况。如果左上角就有障碍，即grid[0][0]为1，则返回的路径数为0，程序结束，因为所有都要从左上角开始。

用数组paths[m][n]来保存各个位置的路径数目。初始化paths[0][0]为1。

然后，对于上边的一行，如果没有障碍，则该位置的路径数与其左侧的相同：

```
对于1 <= j <= n-1，如果grid[0][j]==1，则paths[0][j]=0，否则paths[0][j]=paths[0][j-1]
```

同理，对于左边的元素也一样：

```
对于1 <= i <= m-1，如果grid[i][0]==1，则paths[i][0]=0，否则paths[i][0]=paths[i-1][0]
```

对于中间的元素:

```
如果grid[i][j]==1，则paths[i][j]=0，否则paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
```

最后返回paths[m-1][n-1]即可。

具体的代码为：

Java:

```
    /**
     * 有障碍
     */
    private static final int HAS_GRID = 1;
    /**
     * 无障碍
     */
    private static final int NO_GRID = 0;


    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == HAS_GRID) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == HAS_GRID) {
                paths[0][j] = 0;
            } else {
                paths[0][j] = paths[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == HAS_GRID) {
                paths[i][0] = 0;
            } else {
                paths[i][0] = paths[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == HAS_GRID) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
```

Kotlin:

```
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
```

Python3:

```
class Solution:
    """
    @param: obstacleGrid: A list of lists of integers
    @return: An integer
    """

    def uniquePathsWithObstacles(self, obstacleGrid):
        if not obstacleGrid or len(obstacleGrid) == 0 or len(obstacleGrid[0]) == 0:
            return 0
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        # 初始化paths
        paths = []
        for i in range(0, m):
            temp = []
            for j in range(0, n):
                temp.append(0)
            paths.append(temp)
        paths[0][0] = 1

        for j in range(1, n):
            if obstacleGrid[0][j] == 1:
                paths[0][j] = 0
            else:
                paths[0][j] = paths[0][j - 1]

        for i in range(1, m):
            if obstacleGrid[i][0] == 1:
                paths[i][0] = 0
            else:
                paths[i][0] = paths[i - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    paths[i][j] = 0
                else:
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
        return paths[m - 1][n - 1]
```

JavaScript:

```
/**
 * @param obstacleGrid: A list of lists of integers
 * @return: An integer
 */
const uniquePathsWithObstacles = function (obstacleGrid) {
    if (obstacleGrid === null || obstacleGrid.length === 0 || obstacleGrid[0].length === 0) {
        return 0;
    }

    var m = obstacleGrid.length;
    var n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] === 1) {
        return 0;
    }

    var paths = [];
    for (var i = 0; i < m; i++) {
        var temp = [];
        for (var j = 0; j < n; j++) {
            temp.push(0);
        }
        paths.push(temp);
    }
    paths[0][0] = 1;

    for (j = 1; j < n; j++) {
        if (obstacleGrid[0][j] === 1) {
            paths[0][j] = 0;
        } else {
            paths[0][j] = paths[0][j - 1];
        }
    }

    for (i = 1; i < m; i++) {
        if (obstacleGrid[i][0] === 1) {
            paths[i][0] = 0;
        } else {
            paths[i][0] = paths[i - 1][0];
        }
    }

    for (i = 1; i < m; i++) {
        for (j = 1; j < n; j++) {
            if (obstacleGrid[i][j] === 1) {
                paths[i][j] = 0;
            } else {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
    }
    return paths[m - 1][n - 1];
};
```


