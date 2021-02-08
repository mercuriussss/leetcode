package com.cjl.sword;

import com.cjl.common.ListNode;

/*
    问题描述：
        输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    示例：
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
    限制：
        0 <= 链表长度 <= 1000
 */
public class Sword_25 {

    // 伪头结点遍历法
    // 时间复杂度O(M+N)，空间复杂度O(1)，M为l1节点数，N为l2节点数
    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 != null ? l1 : l2;
        return head.next;
    }

    // 递归法
    // 时间复杂度O(M+N)，空间复杂度O(1)
    public ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if(l1.val <= l2.val){
            l1.next = solution2(l1.next,l2);
            return l1;
        }
        l2.next = solution2(l1,l2.next);
        return l2;
    }
}
