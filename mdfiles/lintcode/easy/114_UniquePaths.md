### [LintCode 114. 不同的路径](http://www.lintcode.com/zh-cn/problem/unique-paths/)

**题目描述：**

有一个机器人的位于一个 m × n 个网格左上角。
机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
问有多少条不同的路径？

```
注意事项
n和m均不超过100
```

**样例:**

```
给出 m = 3 和 n = 3, 返回 6.
给出 m = 4 和 n = 5, 返回 35.
```

**思路：**

从左上角到右下角的不同路径，可以作为一个动态规划的问题。假设一个二位数组nums[m][n]，来存放对应矩阵（网格）中的每一个点的路径数。对于在最上边和最左边的元素，显然其值为1。对于中间的元素，可以由其左边和上边的元素相加得来。即

```
对于0<=i<=m, 0<=j<=n，当i或者j为0的时候，nums[i][j]=0.
当i>=1，j>=1时，nums[i][j] = nums[i-1][j] + nums[i][j-1].
```

最后返回右下角的元素，即nums[m-1][n-1]。

此算法的时间复杂度是O(m*n),空间复杂度是O(m*n)。

具体的代码为:

Java:

```
    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            nums[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }
```

Kotlin:

```
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
```

Python3:

```
    """
    @param: m: positive integer (1 <= m <= 100)
    @param: n: positive integer (1 <= n <= 100)
    @return: An integer
    """
    def uniquePaths(self, m, n):
        nums = []
        for i in range(m):
            temps = []
            for j in range(n):
                if i == 0 or j == 0:
                    temps.append(1)
                else:
                    temps.append(0)
            nums.append(temps)
        for i in range(1, m):
            for j in range(1, n):
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1]
        return nums[m - 1][n - 1]
```

JavaScript:

```
/**
 * @param m: positive integer (1 <= m <= 100)
 * @param n: positive integer (1 <= n <= 100)
 * @return: An integer
 * 114. 不同的路径
 * http://www.lintcode.com/zh-cn/problem/unique-paths/
 */
const uniquePaths = function (m, n) {
    var nums = [];
    for (var i = 0; i < m; i++) {
        var temp = [];
        for (var j = 0; j < n; j++) {
            if (i === 0 || j === 0) {
                temp.push(1);
            } else {
                temp.push(0);
            }
        }
        nums.push(temp);
    }
    for (i = 1; i < m; i++) {
        for (j = 1; j < n; j++) {
            nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
        }
    }
    return nums[m - 1][n - 1];
};
```



