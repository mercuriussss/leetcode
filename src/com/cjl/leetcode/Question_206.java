package com.cjl.leetcode;

import com.cjl.common.ListNode;

/*
    206. 反转链表
    问题描述：
        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    示例 1：
        输入：head = [1,2,3,4,5]
        输出：[5,4,3,2,1]
    示例 2：
        输入：head = [1,2]
        输出：[2,1]
    示例 3：
        输入：head = []
        输出：[]
    提示：
        链表中节点的数目范围是 [0, 5000]
        -5000 <= Node.val <= 5000
 */
public class Question_206 {

    // 递归解法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public ListNode solution1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = solution1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    // 双指针解法
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public ListNode solution2(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while(cur != null){
            // 记录下一节点位置
            tmp = cur.next;
            // 将当前当前节点的next指向pre
            cur.next = pre;
            // pre和cur都往前进一节点
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
