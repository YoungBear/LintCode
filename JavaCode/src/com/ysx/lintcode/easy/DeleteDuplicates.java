package com.ysx.lintcode.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * 112. 删除排序链表中的重复元素
 * http://www.lintcode.com/zh-cn/problem/remove-duplicates-from-sorted-list/
 *
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 *
 * 样例
 * 给出 1->1->2->null，返回 1->2->null
 * 给出 1->1->2->3->3->null，返回 1->2->3->null
 *
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates test = new DeleteDuplicates();
        ListNode p = new ListNode(1);
        ListNode p1 = new ListNode(1);
        p.next = p1;
        ListNode p2 = new ListNode(2);
        p1.next = p2;
        ListNode p3 = new ListNode(3);
        p2.next = p3;
        ListNode p4 = new ListNode(3);
        p3.next = p4;

        System.out.println("before...");
        for (ListNode q = p; q != null; q = q.next) {
            System.out.println(q.val);
        }

        ListNode pa = test.deleteDuplicates(p);
        System.out.println("after...");
        for (ListNode q = pa; q != null; q = q.next) {
            System.out.println(q.val);
        }

    }

    /*
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            int val = p.val;
            ListNode q = p.next;
            while (q != null && q.val == val) {
                q = q.next;
            }
            p.next = q;
        }
        return head;
    }
}
