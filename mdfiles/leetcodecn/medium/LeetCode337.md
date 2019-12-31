# [LeetCode 337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)

## 1. 题目描述

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。



## 2. 思路

参考[官方解答](https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/)



### 说明
本题目本身就是动态规划的树形版本，通过此题解，可以了解一下树形问题在动态规划问题解法
我们通过3个方法不断递进解决问题

- 解法1通过递归实现，虽然解决了问题，但是复杂度太高
- 解法2通过解决方法1中的重复子问题，实现了性能的百倍提升
- 解法3 直接省去了重复子问题，性能又提升了一步

### 解法1-暴力递归-最优子结构：

在解法1和解法2中 我们使用爷爷-两个孩子-4个孙子来说明问题
首先来定义这个问题的状态
爷爷节点获取到最大的偷取的钱数。

- 首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
- 二叉树只有左右两个孩子，一个爷爷最多2个儿子,4个孙子

根据以上条件，我们可以得出单个节点的钱：

- money1 = 4个孙子偷的钱 + 爷爷的钱
- money2 = 两个儿子偷的钱

求max(money1, money2)即可。这就是动态规划里面的最优子结构。

表示为java代码：

```
money1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)

money2 = rob(root.left) + rob(root.right)
```

所以，最终代码为：

```java
    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // money表示选择爷爷节点+4个孙子节点
        int money1 = root.val;
        if (null != root.left) {
            money1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (null != root.right) {
            money1 += (rob(root.right.left) + rob(root.right.right));
        }
        // money2表示选择两个子节点
        int money2 = rob(root.left) + rob(root.right);
        return Math.max(money1, money2);
    }
```

解法1的结果：

726 ms    38.2 MB



### 解法2-记忆化-解决重复子问题

在解法1中，递归会重复计算多次同一个节点的值，导致时间过慢。可以使用一个HashMap来缓存这些节点的值，保证同一个节点的值只会被计算一次。

```java
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robWithCache(root, map);
    }

    private int robWithCache(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (null == root) {
            return 0;
        }
        // money表示选择爷爷节点+4个孙子节点
        int money1 = root.val;
        if (null != root.left) {
            money1 += (robWithCache(root.left.left, map) + robWithCache(root.left.right, map));
        }
        if (null != root.right) {
            money1 += (robWithCache(root.right.left, map) + robWithCache(root.right.right, map));
        }
        // money2表示选择两个子节点
        int money2 = robWithCache(root.left, map) + robWithCache(root.right, map);
        int money = Math.max(money1, money2);
        // 缓存到map中
        map.put(root, money);
        return money;
    }
```

解法2的结果：

6 ms    41 MB

### 解法3-终极解法

上面两种解法用到了孙子节点，计算爷爷节点能偷的钱还要同时去计算孙子节点投的钱，虽然有了记忆化，但是还是有性能损耗。

我们换一种办法来定义此问题
每个节点可选择**偷或者不偷**两种状态，根据题目意思，相连节点不能一起偷

- 当前节点选择偷时，那么两个孩子节点就不能选择偷了

- 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)

我们使用一个大小为2的数组来表示 int[] res = new int[2] 。0代表不偷，1代表偷
任何一个节点能偷到的最大钱的状态可以定义为

1. 当前节点选择不偷: 当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
2. 当前节点选择偷: 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数。

```java
root[0] = Math.max(robInternal(root.left)[0] + robInternal(root.left)[1]) + Math.max(robInternal(root.right)[0] + robInternal(root.right)[1])
root[1] = robInternal(root.left)[0] + robInternal(root.right)[0] + root.val
// 最后返回： Math.max(root[0], root[1])
```

完整代码：

```java
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 返回一个数组 result[2]
     * result[0] 表示不偷当前节点，当前节点可以偷到的最大值：左孩子可以偷到的钱+右孩子可以偷到的钱
     * result[1] 表示偷当前节点，当前节点可以偷到的最大值： 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * 即
     * root[0] = Math.max(robInternal(root.left)[0] + robInternal(root.left)[1]) + Math.max(robInternal(root.right)[0] +
     * robInternal(root.right)[1])
     * root[1] = robInternal(root.left)[0] + robInternal(root.right)[0] + root.val
     * 最后返回： Math.max(root[0], root[1])
     *
     * @param root
     * @return
     */
    private int[] robInternal(TreeNode root) {
        int[] result = new int[2];
        Arrays.fill(result, 0);
        if (null == root) {
            return result;
        }
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
```