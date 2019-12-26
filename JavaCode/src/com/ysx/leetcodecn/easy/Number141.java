package com.ysx.leetcodecn.easy;

import com.ysx.lintcode.common.ListNode;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019/12/26 22:30
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Number141 {

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
}
