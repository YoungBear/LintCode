# LintCode 练习

## [LintCode 官网](http://www.lintcode.com/zh-cn/problem/)

### [第k大元素](http://www.lintcode.com/zh-cn/problem/kth-largest-element/)

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