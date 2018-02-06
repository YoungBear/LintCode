### [793. 数组的交集](http://www.lintcode.com/zh-cn/problem/intersection-of-arrays/)

[更多题目](https://github.com/YoungBear/LintCode/blob/master/README.md)

**题目描述：**

给出多个数组，求它们的交集。输出他们交集的大小。

```
 注意事项

1. 输入的所有数组元素总数不超过500000。
2. 题目数据每个数组里的元素没有重复。
```

**样例**

```
1. 给出 [[1,2,3],[3,4,5],[3,9,10]]，返回 1。

解释：
只有元素3在所有的数组中出现过。交集为[3]，大小为1。

2. 给出 [[1,2,3,4],[1,2,5,6,7],[9,10,1,5,2,3]]，返回2。

解释：
只有元素1,2均在所有的数组出现过。交集为[1,2]，大小为2。
```

**思路：**

根据集合的的点，每次求两个数组的交集，然后用结果和后面的数组求交集。最后求结果的大小即可。

先把第一个数组的元素存放在一个集合resultSet中，然后从第二个数组开始，使用一个辅助集合tempSet，如果该resultSet包含数组中的元素，则将该元素添加到tempSet中，则tempSet是前两个数组的交集，将resultSet清空，然后将tempSet中的元素添加到resultSet中，然后再将tempSet清空。这样，每一次大的循环，resultSet都表示当前的交集，该循环结束后，tempSet则表示下一次的交集。最后赶回resultSet.size()即可。

java代码为：

```
    public int intersectionOfArrays(int[][] arrs) {
        if (null == arrs || arrs.length == 0) {
            return 0;
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < arrs[0].length; i++) {
            resultSet.add(arrs[0][i]);
        }
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (resultSet.contains(arrs[i][j])) {
                    tempSet.add(arrs[i][j]);
                }
            }
            resultSet.clear();
            resultSet.addAll(tempSet);
            tempSet.clear();
        }
        return resultSet.size();
    }
```