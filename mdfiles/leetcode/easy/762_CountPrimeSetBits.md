### [762. Prime Number of Set Bits in Binary Representation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/)

**题目描述：**

Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

简单翻译一下，输入为两个Integer数L和R，代表一个区间，输出为在这个区间内的满足以下条件的数的**个数**：使用二进制表示的这个数，其1的数目之和为素数。

**思路：**

对于32位Integer来说，其所有数使用二进制表示的时候，1的数目之和最大为32（即全部为1，Integer.MAX_VALUE），所以，我们可以找到32之内的素数列表：{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}。然后遍历L到R之间的每一个数，获取其二进制表示的1的数目之和，然后判断是否在这个列表中，如果是，则结果加1。最后返回结果。

具体代码：

Java:

```
    private static final List<Integer> PRIME_LIST = Arrays.asList(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31
    );


    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (PRIME_LIST.contains(count1(i))) {
                result++;
            }
        }
        return result;
    }

    public static int count1(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n /= 2;
        }
        return result;
    }
```

Kotlin:

```
    private val PRIME_LIST = listOf<Int>(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

    fun countPrimeSetBits(L: Int, R: Int): Int {
        var i = L
        var result = 0
        while (i <= R) {
            if (PRIME_LIST.contains(count1(i))) {
                result++
            }
            i++
        }
        return result
    }

    /**
     * 计算n使用二进制表示的时候，1的个数
     */
    fun count1(n: Int): Int {
        var num = n
        var result = 0
        while (num > 0) {
            result += num % 2
            num /= 2
        }
        return result
    }
```

Python3:

```
    PRIME_LIST = (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

    def countPrimeSetBits(self, L, R):
        """
        :type L: int
        :type R: int
        :rtype: int
        """
        result = 0
        for i in range(L, R + 1):
            if self.count1(i) in self.PRIME_LIST:
                result += 1
        return result

    def count1(self, n):
        """
        计算n使用二进制表示的时候，1的个数
        :param n:
        :return:
        """
        result = 0
        b = bin(n)
        for x in b:
            if x == '1':
                result += 1
        return result
```

