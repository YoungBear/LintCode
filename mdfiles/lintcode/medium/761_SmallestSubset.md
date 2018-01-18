### [761. Smallest Subset](http://www.lintcode.com/zh-cn/problem/smallest-subset/)

[更多题目](https://github.com/YoungBear/LintCode/blob/master/README.md)

**题目描述：**

Given an array of **non-negative** integers. Our task is to find minimum number of elements such that their sum should be greater than the sum of rest of the elements of the array.

样例
Given nums = [3, 1, 7, 1], return 1
Given nums = [2, 1, 2], return 2

**简单翻译下：**

输入一个非负的int数组。要求找到最小的数目的元素数，满足这些元素之和比剩余的元素之和大。

**思路：**

1. 先排序
2. 计算出数组元素的和
3. 然后从后往前遍历，累加元素，当累加的数大于剩余的数时，满足条件

具体代码：

java：

```
    public int minElements(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        int curSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (curSum > sum - curSum) {
                return nums.length - i - 1;
            } else {
                curSum += nums[i];
            }
        }
        return 0;
    }
}
```

Python3:

```
    def minElements(self, nums):
        nums.sort(reverse=True)
        sumA = sum(nums)
        num = 0
        curSum = 0
        for item in nums:
            if curSum > sumA - curSum:
                return num
            curSum += item
            num += 1
```

Kotlin:

```
    fun minElements(nums: IntArray): Int {
        Arrays.sort(nums)
        var sum = 0
        for (item in nums){
            sum += item
        }
        val lenA = nums.size
        var curSum = 0
        for (i in lenA - 1 downTo 0) {
            if (curSum > sum - curSum) {
                return lenA - i - 1
            } else {
                curSum += nums[i]
            }
        }
        return 0
    }
```

JavaScript:

```
var anagramMappings = function(A, B) {
    var len = A.length;
    var result = new Array(len);
    for(var i = 0; i < len; i++){
        for (var j = 0; j < len; j++) {
            if (A[i] === B[j]){
                result[i] = j;
                break;
            }
        }
    }
    return result;
};
```


