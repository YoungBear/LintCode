package com.ysx.lintcode.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * 167. 链表求和
 * http://www.lintcode.com/zh-cn/problem/add-two-numbers/
 *
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddLists {

    public static void main(String[] args) {
        AddLists test = new AddLists();
        ListNode head1 = new ListNode(3);
        ListNode p1 = new ListNode(1);
        head1.next = p1;
        ListNode p2 = new ListNode(5);
        p1.next = p2;

        ListNode head2 = new ListNode(5);
        ListNode q1 = new ListNode(9);
        head2.next = q1;
        ListNode q2 = new ListNode(3);
        q1.next = q2;

        ListNode result = test.addLists(head1, head2);
        for (ListNode q = result; q != null; q = q.next) {
            System.out.println(q.val);
        }

    }

    /**
     *
     * 遍历两个链表，只要有一个非空
     * 当前的值为两个链表所在位置的值的和，如果一个链表为空，则取0
     * 用hasFlag来标记是否有进位
     * @param l1 链表1
     * @param l2 链表2
     * @return 两个链表的和
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        /**
         * 是否有进位
         */
        boolean hasFlag = false;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + (hasFlag ? 1 : 0);
            if (val >= 10) {
                hasFlag = true;
                val %= 10;
            } else {
                hasFlag = false;
            }
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (hasFlag) {
            ListNode node = new ListNode(1);
            tail.next = node;
            tail = node;
        }
        return head;
    }
}
