package com.cjl.sword;

import com.cjl.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/*
    问题描述：
        输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
    示例 1:
        给定二叉树 [3,9,20,null,null,15,7]
            3
           / \
          9  20
            /  \
           15   7
        返回 true 。
    示例 2:
        给定二叉树 [1,2,2,3,3,null,null,4,4]

               1
              / \
             2   2
            / \
           3   3
          / \
         4   4
        返回 false 。
    限制：
        1 <= 树的结点个数 <= 10000
 */
public class Solution_55_II {


    // 先序遍历+判断深度（从顶至底）
    // 由于会产生大量重复计算，时间复杂度比较高
    // 时间复杂度O(NlogN)，空间复杂度O(N)
    public boolean solution1(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && dfs(root.left) && dfs(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    // 后序遍历+剪枝（从底至顶）
    // 时间复杂度O(N)，空间复杂度O(N)
    public boolean solution2(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
