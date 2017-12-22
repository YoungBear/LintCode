package com.ysx.lintcode.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * 174. 删除链表中倒数第n个节点
 * http://www.lintcode.com/zh-cn/problem/remove-nth-node-from-end-of-list/
 *
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
 * 链表中的节点个数大于等于n
 * 给出链表1->2->3->4->5->null和 n = 2.
 * 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        head.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;
        ListNode p3 = new ListNode(4);
        p2.next = p3;
        ListNode p4 = new ListNode(5);
        p3.next = p4;

        System.out.println("before...");
        for (ListNode q = head; q != null; q = q.next) {
            System.out.println(q.val);
        }

        ListNode pa = test.removeNthFromEnd(head, 5);
        System.out.println("after...");
        for (ListNode q = pa; q != null; q = q.next) {
            System.out.println(q.val);
        }

    }

    /**
     * 快慢指针
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        /**
         * 如果fast为null，表明n为链表的长度，即删除第1个节点，返回head.next
         */
        if (fast == null) {
            return head.next;
        } else {
            slow.next = slow.next.next;
            return head;
        }
    }
}
