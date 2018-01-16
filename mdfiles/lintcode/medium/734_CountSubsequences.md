
### [734. 形式为a^i b^j c^k的子序列数量](http://www.lintcode.com/zh-cn/problem/number-of-subsequences-of-form-ai-bj-ck/)

**题目描述:**

给一字符串, 对形式为 `a^i b^j c^k `的子序列进行计数, 即它由 i 个字符 a, 接着是 j 个字符 b, 然后是 k 个字符 c组成, `i >= 1, j >= 1, k >= 1`.

Note: 如果两个子序列在原字符串中的index集合是不同的，则认为两个子序列不同。

**样例**

给定 `s = abbc`, 返回 3 子序列为 abc, abc 和 abbc

给定 `s = abcabc`, 返回 7 子序列为 abc, abc, abbc, aabc, abcc, abc 和 abc

**思路：**

分别用变量aCount，bCount，cCount来表示a，b，c出现的次数。则cCount的值与所有满足条件的子串的数量是一致的。

可以得出这样的迭代关系：

1. `aCount = aCount + aCount + 1`:对于a，分为三种情况：第一种情况，直接忽略这个a，使用前边的a，这样的数量是aCount；第二种情况，跟随前边的a，即aa，这样的数量也是aCount；第三种情况，这个a重新作为一个开始，这样的数量是1。所以就有上边的公式成立。
2. `bCount = aCount + bCount + bCount`: 对于b，有三种情况：第一种情况，直接忽略这个b，使用前边的b，这样的数量为bCount；第二种情况，跟随前边的b，即bb，这样的数量是bCount；第三种情况，不使用前边的b，而以这个b直接跟随a，这样的数量为aCount。
3. `cCount = bCount + cCount + cCount`:与b同理。

所以，就可以得到这样的代码：

```
    /*
     * @param : the input string
     * @return: the number of subsequences
     */
    public int countSubsequences(String source) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        for (int i = 0; i < source.length(); i++) {
            switch (source.charAt(i)) {
                case 'a':
                    aCount = aCount + aCount + 1;
                    break;
                case 'b':
                    bCount = aCount + bCount + bCount;
                    break;
                case 'c':
                    cCount = bCount + cCount + cCount;
                    break;
                default:
                    break;
            }
        }
        return cCount;
    }
```

[参考kaaokou的博客](http://blog.csdn.net/kaaokou/article/details/78559667)
