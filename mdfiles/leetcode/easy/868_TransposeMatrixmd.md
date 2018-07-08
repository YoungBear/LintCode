### [868. Transpose Matrix](https://leetcode.com/problems/transpose-matrix/description/)

**题目描述**

Given a matrix `A`, return the transpose of `A`.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

 

**Example 1:**

```
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
```

**Example 2:**

```
Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
```

 

**Note:**

1. `1 <= A.length <= 1000`
2. `1 <= A[0].length <= 1000`

**简单翻译下：**

输入一个矩阵，输出这个矩阵的转置矩阵。

矩阵的转置是矩阵在主对角线上翻转，交换矩阵的行和列指标。

**思路：**

输入的矩阵为A，其行数为`m = A.length`，其列数为`n = A[0].length`，即A是`m x n`的矩阵。转置后为矩阵B，则根据转置的定义，B的行数为`n`，列数为`m`，则B是`n x m`的矩阵。

所有，new一个`n x m`的矩阵B，遍历矩阵B，其中的元素关系为`B[i][j] = A[j][i]`。

**具体代码为：**

Java:

```
    public int[][] transpose(int[][] A) {
        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }
```

Kotlin:

```
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        val B = Array(A[0].size) { IntArray(A.size) }
        for (i in B.indices) {
            for (j in 0 until B[i].size) {
                B[i][j] = A[j][i]
            }
        }
        return B
    }
```

Python3:

```
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        B = []
        for i in range(len(A[0])):
            temp = []
            for j in range(len(A)):
                temp.append(A[j][i])
            B.append(temp)
        return B
```

JavaScript:

```
var transpose = function(A) {
    var B = [];
    for (var i = 0; i < A[0].length; i++) {
        var temp = [];
        for (var j = 0; j < A.length; j++) {
            temp.push(A[j][i]);
        }
        B.push(temp);
    }
    return B;
};
```





## [更多练习题](https://github.com/YoungBear/LintCode)




    

