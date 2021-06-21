package com.cjl.old.sword;

import com.cjl.common.ListNode;

/*
    问题描述：
        定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    示例：
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
    限制：
        0 <= 节点个数 <= 5000
 */
public class Sword_24 {

    // 前后双指针解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public ListNode solution1(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归解法
    // 时间复杂度O(N)，空间复杂度O(N)
    public ListNode solution2(ListNode head){
        return reverse(head,null);
    }

    private ListNode reverse(ListNode cur, ListNode pre){
        if(cur == null){
            return pre;
        }
        ListNode res = reverse(cur.next,cur);
        cur.next = pre;
        return res;
    }
}
