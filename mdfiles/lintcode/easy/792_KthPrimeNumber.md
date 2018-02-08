### [792. Kth Prime Number 求一个素数是第几个素数](http://www.lintcode.com/zh-cn/problem/kth-prime-number/)

**题目描述：**

给出素数n，输出它是第几个素数。

**思路：**

1. 写一个函数，判断一个数是否为素数；
2. 从2开始，一直到n，遍历每一个数，如果是素数，则计数器加1，最后返回计数器的值即可。

具体代码：

java:

```
/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
public class KthPrimeNumber {

    public static void main(String[] args) {
        KthPrimeNumber test = new KthPrimeNumber();
        System.out.println(test.kthPrime(2));
        System.out.println(test.kthPrime(3));
        System.out.println(test.kthPrime(5));
        System.out.println(test.kthPrime(7));

    }

    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                index++;
            }
        }
        return index;
    }

    /**
     * 判断n是否为素数
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n ==0 || n == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

Kotlin:

```
/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
class KthPrimeNumber {

    /**
     * @param n: the number
     * @return: the rank of the number
     */
    fun kthPrime(n: Int): Int {
        var index = 0
        for (i in 2..n) {
            if (isPrime(i)) {
                index++
            }
        }
        return index
    }

    /**
     * 判断一个数是否为素数
     */
    fun isPrime(n: Int): Boolean {
        if (n == 0 || n == 1) {
            return false
        }
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}
```

Python3:

```
import math
class Solution:
    def kthPrime(self, n):
        index = 0
        for i in range(2, n+1):
            if self.isPrime(i):
                index += 1
        return index


    def isPrime(self, n):
        """
        判断一个数是否为素数
        :param n:
        :return:
        """
        if n == 0 or n == 1:
            return False
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
        return True
```

JavaScript:

```
/**
 * 792. Kth Prime Number
 * http://www.lintcode.com/zh-cn/problem/kth-prime-number/
 * 判断素数n是第几个素数
 */
var kthPrimeNumber = function (n) {
    var index = 0;
    for (var i = 2; i <= n; i++) {
        if (isPrime(i)) {
            index++;
        }
    }
    return index;
};

/**
 * 判断一个数是否为素数
 * @param n
 * @returns {boolean}
 */
var isPrime = function (n) {
    if ( n === 0 || n === 1){
        return false;
    }
    for (var i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
};
```
