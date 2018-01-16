### [742. Digit Divide Numbers](http://www.lintcode.com/zh-cn/problem/digit-divide-numbers/)

**题目描述:**

A Digit Divide Numbers is a number that is divisible by every digit it contains.

For example, 128 is a Digit Divide Numbers because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, Digit Divide Numbers is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible Digit Divide Numbers, including the bounds if possible.

简单翻译一下：

一个Digit Divide Numbers是指，这个数可以被每一位的数所整除。例如，128就是一个Digit Divide Numbers，因为对于每一位的数：1,2,8，128均可以整除（取余数为0）。另外，如果包含0，则不是Digit Divide Numbers。输入两个数lower和upper，输出一个列表，在这两个数之间的所有的Digit Divide Numbers(包含两端)，都要在这个列表里。

**注意事项**

```
0<=lower<=upper<=2^31-1
upper-lower<=10^6
```

比如，输入lower = 1, upper = 22, return [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]。

**思路：**

写一个函数，用来判断一个数，是否为Digit Divide Number。即遍历每一位的数字，如果为0或者不能被该数整除，则直接返回false。否则，全部遍历完成之后，返回true。

```
    /**
     * 判断一个数是否可以被每一位的数整除
     * @param n
     * @return
     */
    public static boolean isDigitDivideNum(int n) {
        int temp = n;
        for (int i = temp % 10; temp > 0; temp = temp / 10, i = temp % 10) {
            if (i == 0 || n % i != 0) {
                return false;
            }
        }
        return true;
    }
```

然后，再用一个循环，遍历lower和upper之间的数，逐个去判断，如果满足条件，则添加到结果列表。最后返回列表即可。

```
    /**
     * @param lower: Integer : lower bound
     * @param upper: Integer : upper bound
     * @return: a list of every possible Digit Divide Numbers
     */
    public List<Integer> digitDivideNums(int lower, int upper) {
        /**
         * 需要判断i是否大于等于0，因为Integer的范围是-2^32 -到 2^32 -1
         * 即-2147483648 到 2147483647
         * 当2147483647再加1的时候，由于超出了Integer的最大值，所以结果就变成了-2147483648
         * 就会导致一直死循环。
         */
        List<Integer> resultList = new LinkedList<>();
        for (int i = lower; i >= 0 && i <= upper; i++) {
            if (isDigitDivideNum(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }
```

<font color=red>**注意：**</font>

循环的时候，需要判断i是否大于等于0，因为Integer的范围是-2^32 -到 2^32 -1。upper的值可能为Integer.MAX，即2^32 - 1，如果再加1，则会溢出，i就会变为Integer.MIN，即-2^32。这样就会陷入无限循环中。所以还要加一个条件i >= 0。

