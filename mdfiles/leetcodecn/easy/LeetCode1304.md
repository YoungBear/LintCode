# [LeetCode 1304. 和为零的N个唯一整数](https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/)

## 1. 题目描述

给你一个整数 `n`，请你返回 **任意** 一个由 `n` 个 **各不相同** 的整数组成的数组，并且这 `n` 个数相加和为 `0` 。

## 2. 思路

从-n/2 到 n/2
如

- 当n=1时，返回{0}
- 当n=2时，返回{-1,1}
- 当n=3时，返回{-1,0,1}
- ...

即当n为奇数时，返回从-(n-1)/2到(n-1)/2，并包含0。

当n为偶数时，返回从-n/2到n/2，不包含0。

可以循环n/2次，每次填充两边两个数，即arr[i]和arr[n-i-1]。直到中间为止。（数组初始化元素为0，中间的0不用特殊处理）

**执行结果：**
执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
内存消耗 :34.9 MB, 在所有 java 提交中击败了100.00%的用户

## 3. java 代码

```java
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0, j = n / 2; i < n / 2; i++, j--) {
            arr[i] = j;
            arr[n - i - 1] = -j;
        }
        return arr;
    }
```



