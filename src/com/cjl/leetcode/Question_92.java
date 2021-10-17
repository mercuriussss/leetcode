package com.cjl.leetcode;

import com.cjl.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    92. 反转链表 II
    问题描述：
        给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
        请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    示例 1：
        输入：head = [1,2,3,4,5], left = 2, right = 4
        输出：[1,4,3,2,5]
    示例 2：
        输入：head = [5], left = 1, right = 1
        输出：[5]
    提示：
        链表中节点数目为 n
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n
 */
public class Question_92 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public ListNode solution1(ListNode head, int left, int right) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        head = pre.next;

        for (int i = left; i < right; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return result.next;
    }
}
