package com.cjl.sword;

/*
    问题描述：
        输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例 1：
        输入：head = [1,3,2]
        输出：[2,3,1]
    限制：
        0 <= 链表长度 <= 10000
 */

public class Solution_6 {
    int[] res;
    int i;

    public int[] solution1(ListNode head) {
        recur(head, 0);
        return res;
    }

    void recur(ListNode head, int count) {
        if (head == null) {
            res = new int[count];
            i = count - 1;
            return;
        }
        recur(head.next, count + 1);
        res[i - count] = head.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
