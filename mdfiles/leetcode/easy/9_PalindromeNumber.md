### [491. 回文数](http://www.lintcode.com/zh-cn/problem/palindrome-number/)

### [9. Palindrome Number](https://leetcode.com/problems/palindrome-number/description/)

**题目描述:**

判断一个正整数是不是回文数。

回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。

**注意事项**

给的数一定保证是32位正整数，但是反转之后的数就未必了。

**思路：**

对于一个int值的数，翻转这个数，然后对比翻转的和原来的数，如果相等则这个数为回文数。注意：对于32位的最大值为2147483647，其翻转的时候，结果就超出了最大值，所以，我们可以保留最高位不翻转，然后将原数除以10和该数比较，同时需要满足原数对10取余数的结果为刚才生下来的最高位。

具体代码为：

java代码：

```
    public boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int p = num;
        int q = 0;
        /**
         * 当num为Integer.MAX_VALUE: 2147483647时
         * 翻转过来，就会超过int的最大范围，导致出错
         * 所以翻转的时候不获取最高位，这时候结果q就少一位
         * 判断(q == num / 10 && p == num % 10)就满足条件
         */
        while (p >= 10) {
            q = q * 10 + p % 10;
            p = p / 10;
        }
        return q == num / 10 && p == num % 10;
    }
```

Kotlin代码：

```
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var p : Int = x
        var q = 0

        while (p >= 10) {
            q = q * 10 + p % 10
            p /= 10
        }
        return q == x / 10 && p == x % 10
    }
```

Python3代码：

```
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        注意：python3除运算的时候，需要取整，即int(p / 10)，否则结果默认为小数
        """
        if x < 0:
            return False
        p = x
        q = 0
        while p >= 10:
            q = q * 10 + p % 10
            p = int(p / 10)
        return q == int(x / 10) and p == x % 10
```