# [Leetcode 160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

## 1. 题目描述

编写一个程序，找到两个单链表相交的起始节点。

**注意：**

- 如果两个链表没有交点，返回 null.
- 在返回结果后，两个链表仍须保持原有的结构。
- 可假定整个链表结构中没有循环。
- 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。



## 2. 思路

可以想象A+B和B+A的长度是一样的，如果A和B相交，则遍历A+B次后最后的节点是相同的，否则，A和B是不相交的。即双指针法。

[参考](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/)


## 3. java代码

```java
package com.ysx.leetcodecn.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/28 20:26
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Leetcode160 {
    /**
     * 找到两个单链表相交的起始节点
     * 如果不相交，返回 null
     * 方案：可以想象A+B和B+A的长度是一样的，如果A和B相交，则遍历A+B次后最后的节点是相同的，否则，A和B是不相交的
     * 即双指针法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        // 循环条件为a和b不相等
        while (a != b) {
            a = a.next;
            b = b.next;
            // 如果a和b同时为空，则说明没有相交
            if (null == a && null == b) {
                return null;
            }
            // a 到达结尾，连接 headB
            if (null == a) {
                a = headB;
            }
            // b 到达结尾，连接 headA
            if (null == b) {
                b = headA;
            }
        }
        return a;
    }
}
```

