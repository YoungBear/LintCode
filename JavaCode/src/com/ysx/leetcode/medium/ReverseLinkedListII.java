package com.ysx.leetcode.medium;

import com.ysx.lintcode.common.ListNode;

import java.util.List;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * 反转链表，根据输入的m和n，从第m个节点开始到的第n个节点，反转这之间的链表
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {


    public static void main(String[] args) {
        ReverseLinkedListII test = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        head.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;
        ListNode p3 = new ListNode(4);
        p2.next = p3;
        ListNode p4 = new ListNode(5);
        p3.next = p4;
        ListNode q = head;
        System.out.println("before");
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }

        ListNode result = test.reverseBetween(head, 2, 4);
        q = result;
        System.out.println("after");
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }

    }

    /**
     * 翻转链表中间一部分，从第m个点到第n个点，一共翻转n-m-1个节点
     * 思路：找到中间的这一部分，用一个链表start来存储，其中头结点为start，尾节点为end
     * 并找到两端的节点prev和next
     * 翻转中间的链表start
     * 然后连接两端即可
     *
     * @param head
     * @param m 从第m个节点开始翻转
     * @param n 到第n个节点
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev;
        ListNode start;
        if (m == 1) {
            prev = null;
            start = head;
        } else {
            prev = head;
            for (int i = 1; i < m - 1; i++) {
                prev = prev.next;
            }
            start = prev.next;
        }

        ListNode next;
        ListNode end = head;
        for (int i = 1; i < n; i++) {
            end = end.next;
        }
        next = end.next;

        if (prev == null) {
            end.next = null;
            ListNode result = reverse(start);
            start.next = next;
            return result;
        } else {
            prev.next = null;
            end.next = null;
            reverse(start);
            prev.next = end;
            start.next = next;
            return head;
        }
    }

    /**
     * 翻转一个链表
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
