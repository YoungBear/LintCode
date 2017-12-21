package com.ysx.lintcode.medium;

import com.ysx.lintcode.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 223. 回文链表
 * http://www.lintcode.com/zh-cn/problem/palindrome-linked-list/
 *
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class ValidPalindromeList {

    public static void main(String[] args) {
        ValidPalindromeList test = new ValidPalindromeList();
        ListNode q = new ListNode(1);
        System.out.println(test.isPalindrome(q));
    }

    /**
     * 利用快慢指针，先找到中间的节点
     * 然后反转后边的链表，和前边的比较即可
     * 时间复杂度是O(n)，空间复杂度为O(1)
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddleNode(head);
        middle = reverse(middle);
        ListNode p = head;
        ListNode q = middle;
        while (q != null && p != null) {
            if (q.val != p.val) {
                return false;
            }
            q = q.next;
            p = p.next;
        }
        return true;

    }

    /**
     * 使用快慢指针的方法，找到中间节点
     * @param head
     * @return
     */
    public ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
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

    /**
     * 使用一个数组列表存储值，时间复杂度为O(n)，空间复杂度为O(n)
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome2(ListNode head) {
        if (null == head) {
            return true;
        }
        List<Integer> valList = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            valList.add(p.val);
        }
        int length = valList.size();
        for (int i = 0; i < length; i++) {
            if (valList.get(i).intValue() != valList.get(length - i - 1).intValue()) {
                return false;
            }
        }
        return true;
    }
}
