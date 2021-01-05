package com.cjl.sword;

/*
    问题描述：
      给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
      返回删除后的链表的头节点。
    示例 1：
      输入: head = [4,5,1,9], val = 5
      输出: [4,1,9]
    示例 2:
      输入: head = [4,5,1,9], val = 1
      输出: [4,5,9]
 */

import com.cjl.common.ListNode;

public class Solution_18 {


    // 单指针遍历
    public ListNode solution1(ListNode head, int val) {
        ListNode tmp = head;
        if(head == null){
            return null;
        }
        if(head.val == val){
            return head.next;
        }
        while(tmp.next != null && tmp.next.val != val){
            tmp = tmp.next;
        }
        if(tmp.next != null){
            tmp.next = tmp.next.next;
        }
        return head;
    }

    // 双指针遍历
    public ListNode solution2(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
