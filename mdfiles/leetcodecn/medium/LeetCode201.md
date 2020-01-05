# [LeetCode 201. 数字范围按位与](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/)

## 1. 题目描述

给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

**示例 1:** 

```
输入: [5,7]
输出: 4
```

**示例 2:**

```
输入: [0,1]
输出: 0
```

## 2. 思路

[参考](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--41/)

### 方案1

从m到n，考虑二进制的最低位，如果m<n，则肯定存在m或者n最低位为0，该位按位与的结果为0。

所以，不断右移用来遍历最低位，直到m和n相等，即二进制的公共前缀。记录右移的次数i，最后将m左移i位就是最后的结果。

```java
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m < n) {
            i++;
            m >>= 1;
            n >>= 1;
        }
        return m << i;
    }
```

**优化版：**

由于我们只需要找到m和n的公共前缀，所以，我们可以只遍历n，通过 `n = n & (n - 1)` 将 n 的最右侧的1变为0。

循环的条件是m<n。循环结束时，n和m前缀相同，n的后边均为0，即题目要求的结果值。

```java
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
```



### 方案2

m < n 时，找到 m 和 n 二进制高位**第一个不相同**的位置i，即m[i]=0,n[i]=1。

将 i 位置之前的全部置为1（包括i），其后全部置为0，得到数 x，然后将 m 与这个数 x 按位与即可。

Integer.highestOneBit(k) 是保留最高位的1，其他位置为0，m ^ n，即m与n按位异或，可以找到第一个不同的位置i。

```java
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        return m & ~Integer.highestOneBit(m ^ n) + 1;
    }
```

