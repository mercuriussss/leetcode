package com.cjl.sword;

/*
    问题描述：
        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
        要求不能创建任何新的节点，只能调整树中节点指针的指向。
    示例:
        给定如下二叉搜索树

                      4
                     / \
                    2   5
                   /   /
                  1   3

        我们希望将这个二叉搜索树转化为双向循环链表。
        链表中的每个节点都有一个前驱和后继指针。
        对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 */
public class Solution_36 {


    // 中序遍历
    // 时间复杂度O(N)，空间复杂度O(N)
    Node pre,head;
    public Node solution1(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node cur){
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(pre != null){
            pre.right = cur;
        }else{
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
