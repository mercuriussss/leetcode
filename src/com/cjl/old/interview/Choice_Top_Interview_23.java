package com.cjl.old.interview;

import com.cjl.common.ListNode;

import java.util.*;

/*
    问题描述：
        你一个链表数组，每个链表都已经按升序排列。
        请你将所有链表合并到一个升序链表中，返回合并后的链表。
    示例 1：
        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        解释：链表数组如下：
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        将它们合并到一个有序链表中得到。
        1->1->2->3->4->4->5->6
    示例 2：
        输入：lists = []
        输出：[]
    示例 3：
        输入：lists = [[]]
        输出：[]
    提示：
        k == lists.length
        0 <= k <= 10^4
        0 <= lists[i].length <= 500
        -10^4 <= lists[i][j] <= 10^4
        lists[i] 按 升序 排列
        lists[i].length 的总和不超过 10^4
 */
public class Choice_Top_Interview_23 {

    // 时间复杂度是O(knlogk),空间复杂度是O(k),kn代表k个链表的总节点数
    public ListNode solution1(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (ListNode list : lists) {
            if(list != null){
                pq.offer(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            cur.next = nextNode;
            cur = cur.next;
            if(nextNode.next != null){
                pq.offer(nextNode.next);
            }
        }
        return dummyHead.next;
    }
}
