package com.cjl.leetcode;

import com.cjl.common.ListNode;

/*
    21. 合并两个有序链表
    问题描述：
        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例 1：
        输入：l1 = [1,2,4], l2 = [1,3,4]
        输出：[1,1,2,3,4,4]
    示例 2：
        输入：l1 = [], l2 = []
        输出：[]
    示例 3：
        输入：l1 = [], l2 = [0]
        输出：[0]
    提示：
        两个链表的节点数目范围是 [0, 50]
        -100 <= Node.val <= 100
        l1 和 l2 均按 非递减顺序 排列
 */
public class Question_21 {

    // 时间复杂度O(M+N)，空间复杂度O(1)
    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }

    // 递归法
    // 时间复杂度O(M+N)，空间复杂度O(1)
    public ListNode solution2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2: l1;
        }
        if(l1.val <= l2.val){
            l1.next = solution2(l1.next, l2);
            return l1;
        }
        l2.next = solution2(l1, l2.next);
        return l2;
    }
}
