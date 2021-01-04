package com.cjl.sword;

/*
    问题描述：
        输入一个链表，输出该链表中倒数第k个节点。
        为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
        例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
        这个链表的倒数第3个节点是值为4的节点。
    示例：
        输入：1->2->3->4->5, 和 k = 2
        输出：4->5
 */
public class Solution_22 {

    // 快慢双指针解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public ListNode solution1(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    // 递归解法
    int size;
    public ListNode solution2(ListNode head, int k){
        if (head == null)
            return head;
        ListNode node = solution2(head.next, k);
        if (++size == k)
            return head;
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}