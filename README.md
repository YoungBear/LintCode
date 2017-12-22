# LintCode 与 LeetCode 练习

## [LintCode 官网](http://www.lintcode.com/zh-cn/problem/)
## [LeetCode 算法练习](https://leetcode.com/problemset/algorithms/)

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




### [LeetCode 746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/description/)

**题目描述:**

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

**Example 1:**

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

**Example 2:**

```
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
```

**Note:**
1. cost will have a length in the range [2, 1000].
2. Every cost[i] will be an integer in the range [0, 999].

**简单的翻译下：**

有一个楼梯，每次可以走1层或者2层，cost数组表示每一层所需要花费的值。可以从第一层或者第二层开始。求，到达顶端所花费大的最小的值。

**思路：**

这是一个**动态规划(Dynamic programming, DP)**的问题。

如果我们用一个数组dp[]来存放到达每一层所需要的花费值。则则最终结果是求dp[cost.length]的值。因为每次可以走1层或者2层，并且可以从0或者从1开始，所以可以得到dp[0]为0，dp[1]为0。从2开始，dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，而这i-2和i-1层所要花费的值分别为cost[i-2]和cost[i-1]，所以，`dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])`。该算法的空间复杂度为**O(n)**，时间复杂度为**O(n)**。

具体的Java代码为：

```
    /**
     * @param cost 每一步所要花费的值
     * @return 到达顶部总共需要的值
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length - 1];
    }
```

由于在i大于等于2的情况下，dp[i]只跟dp[i-1]和dp[i-2]接cost数组有关。所以我们只需要用三个变量来存储结果即可， 即`dp0,dp1,dp2`，这样的空间复杂度就变成了**O(1)**。

最终的代码为：

```
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2] , dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }
```

对应**Python3**代码为：

```
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        dp0, dp1, dp2 = 0, 0, 0
        for i in range(2, len(cost) + 1):
            dp2 = min(dp0 + cost[i - 2], dp1 + cost[i - 1])
            dp0,dp1 = dp1,dp2
        return dp2
```

对应**Kotlin**代码为：

```
    fun minCostClimbingStairs(cost: IntArray): Int {
        var dp0 = 0
        var dp1 = 0
        var dp2 = 0

        val length : Int = cost.size + 1
        for (index in 2 until length) {
            dp2 = min(dp0 + cost[index - 2], dp1 + cost[index - 1])
            dp0 = dp1
            dp1 = dp2
        }
        return dp2
    }
```


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