### [744. Sum of first K even-length Palindrome numbers](http://www.lintcode.com/zh-cn/problem/sum-of-first-k-even-length-palindrome-numbers/)

**题目描述:**

Given a integer k, find the sum of first k even-length palindrome numbers.
Even length here refers to the number of digits of a number is even.

样例

```
Given k = 3, return 66 // 11 + 22 + 33 = 66 (Sum of first three even-length palindrome 
numbers)

Given k = 10, return 1496
// 11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 + 1001 = 1496
```

简单翻译下：

输入整数k，返回前k个位数长度为偶数的回文数的和。

**思路：**

设f(n)表示第n个满足条件的数(n >= 1)。f(n)要满足两个条件：
1. 回文数
2. 位数长度为偶数

可以根据要求，列出f(n)的列表：

```
f(1) = 11
f(2) = 22
...
f(9) = 99
f(10) = 1001
f(11) = 1111
...
f(99) = 9999
f(100) = 100001
...
```

可以看出来，第n个数的值，就是将n作为字符串str，翻转之后得到revstr，然后将str和revstr拼接，再转换为整数，就是所需要的结果。如n=100

```
f(100) = 100001
str为"100"
revstr为"001"
str + revstr = "100001"
转换为整数后，结果为100001，即f(n)
```

所以，可以得到java代码：

```
    /**
     * @param k:
     * @return: the sum of first k even-length palindrome numbers
     * 设f(n)为第n个偶数长度的回文数
     * 则f(1)为11，f(2)为22...f(10)为1001
     * 可以看到规律，f(n)为将n作为字符串，翻转后，两个串拼起来的数字
     * 参考：
     * http://www.geeksforgeeks.org/sum-first-k-even-length-palindrome-numbers/
     */
    public int sumKEven(int k) {
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            String str = String.valueOf(i);
            String revstr = str + new StringBuilder().append(str).reverse().toString();
            int cur = Integer.parseInt(revstr);
//            System.out.println("i: " + i + ", cur: " + cur);
            sum += cur;
        }
        return sum;
    }
```

对应的Python3代码为：

```
    def sumKEven(self, k):
        result = 0
        for i in range(1, k + 1):
            # 转换为字符串
            str1 = str(i)
            # 翻转字符串
            revstr1 = str1[::-1]
            # 拼接两个字符串并转换为整数型
            cur = int(str1 + revstr1)
            # print(cur)
            # 添加到结果中
            result = result + cur
        return result
```

参考：

http://www.geeksforgeeks.org/sum-first-k-even-length-palindrome-numbers/

