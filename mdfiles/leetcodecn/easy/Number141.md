# leetcode 141. [环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

## 1. 题目描述

给定一个链表，判断链表中是否有环。

## 2. 思路

使用快慢指针，快指针fast每次移动2个节点，慢支针slow每次移动一个节点。

- 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 `false`。

- 如果链表中存在环，循环中，两个节点最终都会进入环中，而快指针总会超过慢指针n圈(n>=1)，即总会有`fast==slow` 发生，即两个指针指向同一个节点，此时就结束，返回`true`。

## 3. java 代码

```java
    /**
     * 快慢指针判断是否是环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
```

