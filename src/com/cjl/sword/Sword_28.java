package com.cjl.sword;

import com.cjl.common.TreeNode;

/*
    问题描述：
        请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

            1
           / \
          2   2
         / \ / \
        3  4 4  3

        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

            1
           / \
          2   2
           \   \
           3    3
    示例1：
        输入：root = [1,2,2,3,4,4,3]
        输出：true
    示例2：
        输入：root = [1,2,2,null,3,null,3]
        输出：false
    限制：
        0 <= 节点个数 <= 1000
 */
public class Sword_28 {

    // 递归法
    // 时间复杂度O(N)，空间复杂度O(N)，N为二叉树节点数
    public boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode != null && rightNode != null) {
            return (leftNode.val == rightNode.val) && recur(leftNode.left, rightNode.right) && recur(leftNode.right, rightNode.left);
        }
        return (leftNode == null && rightNode == null);
    }
}
