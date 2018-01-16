### [735. Replace With Greatest From Right](http://www.lintcode.com/zh-cn/problem/replace-with-greatest-from-right/)

**题目描述：**

Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is [16, 17, 4, 3, 5, 2], then it should be modified to [17, 5, 5, 5, 2, -1].

中文：输入是一个int数组，对于每个位置的元素，使用该位置<font color=red>**右侧**</font>的元素的<font color=red>**最大值**</font>，来代替该位置的元素。对于最后一个元素，用-1来来填充。

**思路：**

从后往前，找到当前的最大值，并保存。然后将最大值赋值给的指定位置的元素。这样的时间复杂度为O(n)，空间复杂度为O(1)。

java代码：

```
    /*
     * @param : An array of integers.
     * @return: nothing
     * 从后往前，找当前最大的数值
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        // Write your code here.
        int len = nums.length;
        if (len < 1) {
            return;
        }
        int max = nums[len -1];
        nums[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = max;
            if (max < temp) {
                max = temp;
            }
        }
    }
```