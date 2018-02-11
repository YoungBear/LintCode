### [Lintcode 64. 合并排序数组](http://www.lintcode.com/zh-cn/problem/merge-sorted-array/)

[更多题目](https://github.com/YoungBear/LintCode/blob/master/README.md)

**题目描述：**

合并两个排序的整数数组A和B变成一个新的数组。

```
注意事项
你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
```

**思路：**

用一个辅助数组temp，遍历数组A和数组B中的每一个元素，如果A中的元素大，则将B中的元素加入temp，否则将A中的元素加入temp。完成之后，再将剩下的元素添加到temp。最后，将temp中的元素，全部复制到数组A中。(如果要求返回新数组，则直接返回temp即可)

具体代码：

Java：

```
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] > B[j]) {
                temp[k++] = B[j++];
            } else {
                temp[k++] = A[i++];
            }
        }
        while (i < m) {
            temp[k++] = A[i++];
        }
        while (j < n) {
            temp[k++] = B[j++];
        }
        for (int t = 0; t < k; t++) {
            A[t] = temp[t];
        }
    }
```

Python3:

```
    """
    @param: A: sorted integer array A which has m elements, but size of A is m+n
    @param: m: An integer
    @param: B: sorted integer array B which has n elements
    @param: n: An integer
    @return: nothing
    """

    def mergeSortedArray(self, A, m, B, n):
        temp = []
        i = 0
        j = 0
        while i < m and j < n:
            if A[i] > B[j]:
                temp.append(B[j])
                j += 1
            else:
                temp.append(A[i])
                i += 1
        while i < m:
            temp.append(A[i])
            i += 1
        while j < n:
            temp.append(B[j])
            j += 1
        for i in range(0, m + n):
            A[i] = temp[i]
```

