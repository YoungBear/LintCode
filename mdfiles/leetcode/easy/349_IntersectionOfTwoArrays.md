### [349. Intersection of Two Arrays 求两个数组的交集](https://leetcode.com/problems/intersection-of-two-arrays/description/)

**题目描述：**

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

```
Note:
Each element in the result must be unique.
The result can be in any order.
```

输入为两个int数组，可能包含重复元素，要求输出两个数组的集合的交集。

**思路：**

将两个数组中的重复元素去掉，另存为arrA和arrB。然后遍历arrB，对于arrB中的每一个元素，如果该元素在arrA中存在，则将该元素添加到结果数组arr中。

特别的：
1. 在Java语言中，可以使用类型Set来存储元素，默认该类型中不会存储重复元素。
2. 在Kotlin语言中，可以使用和MutableSet来存储元素，该类型中也不会存储重复元素，并且，可以直接调用方法intersect()来得到两个集合的交集，然后使用toIntArray()将其转换为数组。

具体代码为：

java:

```
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int item : nums1){
            set1.add(item);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (int item : set2){
            result[i++] = item;
        }
        return result;
    }
```

Kotlin:

```
/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 两个数组的交集
 * Kotlin里边，Set表示不可变集合，MutableSet表示可变集合
 */
class IntersectionOfTwoArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1: MutableSet<Int> = mutableSetOf()
        for (item in nums1) {
            set1.add(item)
        }
        val set2: MutableSet<Int> = mutableSetOf()
        for (item in nums2) {
            set2.add(item)
        }
        return set1.intersect(set2).toIntArray()
    }
}
```

Python3代码：

```
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        # 先去掉nums1和nums2中的重复元素，存为temp1和temp2
        temp1 = []
        len1 = len(nums1)
        for i in range(len1):
            if nums1[i] not in temp1:
                temp1.append(nums1[i])

        temp2 = []
        len2 = len(nums2)
        for i in range(len2):
            if nums2[i] not in temp2:
                temp2.append(nums2[i])

        result = []
        len2 = len(temp2)
        for i in range(len2):
            if temp2[i] in temp1:
                result.append(temp2[i])
        return result
```

JavaScript:

```
/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 *
 * 数组相关方法：
 * indexOf() 搜索数组中的元素，并返回它所在的位置，如果没有该元素则返回-1
 * push() 向数组的末尾添加一个或更多元素，并返回新的长度。
 */
var intersection = function(nums1, nums2) {
    var temp1 = [];
    for(var i = 0; i < nums1.length; i++){
        if (temp1.indexOf(nums1[i]) === -1) {
            temp1.push(nums1[i]);
        }
    }
    var temp2 = [];
    for(var j = 0; j < nums2.length; j++){
        if (temp2.indexOf(nums2[j]) === -1) {
            temp2.push(nums2[j]);
        }
    }
    var result = [];
    for (var k = 0; k < temp2.length; k++){
        if (temp1.indexOf(temp2[k]) !== -1) {
            result.push(temp2[k])
        }
    }
    return result;
};
```


