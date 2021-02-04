package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    问题描述：
        输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    例如：
        给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
          9  20
            /  \
           15   7
        返回它的最大深度 3 。
    提示：
        节点总数 <= 10000
 */
public class Solution_55_I {

    // 层序遍历（BFS）
    // 时间复杂度O(N)，空间复杂度O(N)
    public int solution1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 后序遍历（DFS）
    // 时间复杂度O(N)，空间复杂度O(N)
    public int solution2(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
