package com.ysx.lintcode.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * 35. 翻转链表
 * http://www.lintcode.com/zh-cn/problem/reverse-linked-list/
 *
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseList {

    /*
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
