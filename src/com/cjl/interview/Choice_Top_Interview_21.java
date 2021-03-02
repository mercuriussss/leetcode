package com.cjl.interview;

import com.cjl.common.ListNode;

import java.util.Stack;

/*
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
public class Choice_Top_Interview_21 {

    // 时间复杂度是O(N+M)，空间复杂度是O(N+M)
    public ListNode solution1(ListNode l1, ListNode l2) {
        return recur(l1,l2);
    }
    private ListNode recur(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = recur(l1,l2.next);
            return l2;
        }else{
            l1.next = recur(l1.next,l2);
            return l1;
        }
    }
}
