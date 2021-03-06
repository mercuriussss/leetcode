package com.cjl.old.sword;

import com.cjl.common.Node;

import java.util.HashMap;
import java.util.Map;

/*
    问题描述：
        请实现 copyRandomList 函数，复制一个复杂链表。
        在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
    示例 1：
        输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
    示例 2：
        输入：head = [[1,1],[2,1]]
        输出：[[1,1],[2,1]]
    示例 3：
        输入：head = [[3,null],[3,0],[3,null]]
        输出：[[3,null],[3,0],[3,null]]
    示例 4：
        输入：head = []
        输出：[]
        解释：给定的链表为空（空指针），因此返回 null。
    提示：
        -10000 <= Node.val <= 10000
        Node.random为空（null）或指向链表中的节点。
        节点数目不超过 1000 。
 */
public class Sword_35 {

    // 哈希表对应法
    // 时间复杂度O(N)，空间复杂度O(N)
    public Node solution1(Node head){
        if(head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node tmp = head;
        while(tmp != null){
            map.put(tmp,new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp != null){
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(head);
    }

    // 拼接 + 拆分
    // 时间复杂度O(N)，空间复杂度O(1)
    public Node solution2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        // 复制各节点，构建拼接链表
        while(cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        // 构建各新节点的random指向
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        // 拆分两链表
        while(cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
