package com.cjl.leetcode;

import com.cjl.common.ListNode;

import java.util.Deque;

/*
    143. 重排链表
    问题描述：
        给定一个单链表 L 的头节点 head ，单链表 L 表示为：
        L0→ L1→ … → Ln-1→ Ln
        请将其重新排列后变为：
        L0→Ln→L1→Ln-1→L2→Ln-2→ …
        不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    示例 1:
        输入: head = [1,2,3,4]
        输出: [1,4,2,3]
    示例 2:
        输入: head = [1,2,3,4,5]
        输出: [1,5,2,4,3]
    提示：
        链表的长度范围为 [1, 5 * 10^4]
        1 <= node.val <= 1000
 */
public class Question_143 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public void solution1(ListNode head) {
        if(head == null){
            return;
        }
        // 获得中间节点
        ListNode mid = findMid(head);

        // 中间节点之后的部分进行反转
        ListNode head2 = mid.next;
        // 切割链表，分成前后两部分
        mid.next = null;
        head2 = reverseList(head2);

        // 合并
        mergeList(head,head2);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode next1 = null;
        ListNode next2 = null;
        while(head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }
}
