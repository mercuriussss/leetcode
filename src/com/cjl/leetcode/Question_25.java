package com.cjl.leetcode;

import com.cjl.common.ListNode;

/*
    25. K 个一组翻转链表
    问题描述：
        给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
        k是一个正整数，它的值小于或等于链表的长度。
        如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    示例 1：
        输入：head = [1,2,3,4,5], k = 2
        输出：[2,1,4,3,5]
    示例 2：
        输入：head = [1,2,3,4,5], k = 3
        输出：[3,2,1,4,5]
    示例 3：
        输入：head = [1,2,3,4,5], k = 1
        输出：[1,2,3,4,5]
    示例 4：
        输入：head = [1], k = 1
        输出：[1]
    提示：
        列表中节点的数量在范围 sz 内
        1 <= sz <= 5000
        0 <= Node.val <= 1000
        1 <= k <= sz
    进阶：
        你可以设计一个只使用常数额外空间的算法来解决此问题吗？
        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Question_25 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public ListNode solution1(ListNode head, int k) {
        ListNode res = new ListNode(0);
        ListNode pre = res, cur = head, next;
        res.next = head;
        int len = 0;
        while(head != null){
            len ++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }
        return res.next;
    }
}
