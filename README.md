# LintCode 练习

## [LintCode 官网](http://www.lintcode.com/zh-cn/problem/)

### [728. 3个不同的因子](http://www.lintcode.com/zh-cn/problem/three-distinct-factors/)

**题目描述:**

给一 正整数 `n (1 <= n <= 10^18)`. 判断这个数是否<font color=red>**正好只有 3 个不同的因子**</font>, 如果正好有 3 个不同的因子就返回 true, 否则返回 false。

样例：

- 给出 n = 9, 返回 true 数字 9 正好有 3 个因子: 1, 3, 9, 所以返回 true.
- 给出 n = 10, 返回 false.

**思路：**

如果n只有3个因子，即只能为1,x,n,x是n的平方根，并且x是素数。
所以，我们只需要判断n的平方根是否为素数即可。

```
4,9,25,49...
```

**具体代码：**

```
    /*
     * @param n: the given number
     * @return: true if it has exactly three distinct factors, otherwise false
     * 思路：如果n只有3个因子，即只能为1,x,n,x是n的平方根，并且x是素数。
     * 所以，我们只需要判断n的平方根是否为素数即可。
     * 4,9,25,49...
     */
    public boolean isThreeDisctFactors(long n) {
        long x = (long) Math.sqrt(n);
        /**
         * 如果n不是平方数，则返回false
         */
        if (x * x != n) {
            return false;
        }
        return isPrime(x);
    }

    /**
     * 判断是否为素数
     * @param n
     * @return
     */
    public static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for(int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
```


### [729. 阶乘除法的最后一位数](http://www.lintcode.com/zh-cn/problem/last-digit-by-factorial-divide/)

**题目描述:**

给出两个数 A 和 B, 其中 B >= A. 我们需要计算结果 F 的最后一位数是什么, 其中F = B! / A!(1 <= A, B <= 10^18, A 和 B 非常大)

**思路：**

根据描述，可以得到：

```
F = B! / A!，即F = B*(B-1)*(B-2)*...*(A + 1)
```

主要分为两种情况：

1. 如果B-A >= 10，则表明B和A之间，肯定存在一个数为10的倍数，则这种情况下，末位为0。
2. 如果B-A < 10，则只需要计算<font color=red>**末位的结果**</font>即可。从A+1一直乘到B，用一个int值保存末位值。

主要代码为：

```
    public int computeLastDigit(long A, long B) {
        if (B - A >= 10) {
            return 0;
        }
        int result = 1;
        for (long i = A + 1; i <= B; i++) {
            int temp = (int) (i % 10);
            result = (result * temp) % 10;
        }
        return result;
    }
```

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



### [5.第k大元素](http://www.lintcode.com/zh-cn/problem/kth-largest-element/)

### [735. Replace With Greatest From Right](http://www.lintcode.com/zh-cn/problem/replace-with-greatest-from-right/)

**题目描述：**

Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is [16, 17, 4, 3, 5, 2], then it should be modified to [17, 5, 5, 5, 2, -1].

中文：输入是一个int数组，对于每个位置的元素，使用该位置<font color=red>**右侧**</font>的元素的<font color=red>**最大值**</font>，来代替该位置的元素。对于最后一个元素，用-1来来填充。

**思路：**

从后往前，找到当前的最大值，并保存。然后将最大值赋值给的指定位置的元素。这样的时间复杂度为O(n)，空间复杂度为O(1)。[具体代码](https://github.com/YoungBear/LintCode/blob/master/src/com/ysx/lintcode/practice2017/ReplaceWithGreatestFromRight.java)

### [12. 带最小值操作的栈](http://www.lintcode.com/zh-cn/problem/min-stack/)

**题目描述：**

实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。

你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

样例

如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 2，1

**思路：**

使用两个列表mData和mMinData，分别存储栈的元素和最小值：

```
    // mData模拟一个栈
    private List<Integer> mData;
    // mMinData用来存储最小的值，并且当前最小的值是最后一个元素
    private List<Integer> mMinData;
```

**核心代码：**

即push方法。在第一次的时候，将第一个元素直接添加到mMinData中。之后，判断number与当前最小值的大小，将较小值添加到mMinData中。这样的话，mMinData与mData的长度相等，并且，当前的最小值，都存储在最后一个位置。

```
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        mData.add(number);
        // 第一次push，将第一个元素添加到mMinData中
        if (mMinData.size() == 0) {
            mMinData.add(number);
        } else {
            // 之后，将number与mMinData中的最小值比较，将较小的值添加到mMinData中
            mMinData.add(Math.min(number, mMinData.get(mMinData.size() - 1)));
        }
    }
```

[完整代码](https://github.com/YoungBear/LintCode/blob/master/src/com/ysx/lintcode/practice2017/MinStack.java)

### [14. 二分查找](http://www.lintcode.com/zh-cn/problem/first-position-of-target/)

**题目描述：**

给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target<font color=red>**第一次**</font>出现的下标（从0开始），如果target不存在于数组中，返回-1。

**思路：**

使用二分法，查找指定元素。然后在找到最左边的那个元素，即第一次出现的元素。

```
    public int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int begin = 0;
        int end = len - 1;
        int middle = (begin + end) / 2;
        while (begin <= end) {
            if (target > nums[middle]) {
                begin = middle + 1;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                // 找到第一个出现的元素
                while (middle >= 0 && nums[middle] == target) {
                    middle--;
                }
                return middle + 1;
            }
            middle = (begin + end) / 2;
        }
        return -1;
    }
```