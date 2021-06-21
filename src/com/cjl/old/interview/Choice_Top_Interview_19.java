package com.cjl.old.interview;

import com.cjl.common.ListNode;

/*
    问题描述：
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        进阶：你能尝试使用一趟扫描实现吗？
    示例 1：
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
    示例 2：
        输入：head = [1], n = 1
        输出：[]
    示例 3：
        输入：head = [1,2], n = 1
        输出：[1]
    提示：
        链表中结点的数目为 sz
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
 */
public class Choice_Top_Interview_19 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public ListNode solution1(ListNode head, int n) {
        if(head == null || (head.next == null && n == 1)){
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode res = preHead;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            if(cur == null){
                return head;
            }
            cur = cur.next;
        }
        while(cur != null){
            preHead = preHead.next;
            cur = cur.next;
        }
        preHead.next = preHead.next.next;
        return res.next;
    }


    // 递归法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public ListNode solution2(ListNode head, int n){
        return removeNode(head,n) == n ? head.next: head;
    }
    private int removeNode(ListNode node, int n ){
        if(node.next == null){
            return 1;
        }
        int m = removeNode(node.next,n);
        if(m == n){
            if(m == 1){
                node.next = null;
            }else{
                node.next = node.next.next;
            }
        }
        return m + 1;
    }
}
