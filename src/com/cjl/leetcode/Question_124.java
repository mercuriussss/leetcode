package com.cjl.leetcode;

import com.cjl.common.TreeNode;

/*
    124. 二叉树中的最大路径和
    问题描述：
        路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中至多出现一次。
        该路径至少包含一个节点，且不一定经过根节点。
        路径和是路径中各节点值的总和。
        给你一个二叉树的根节点 root ，返回其最大路径和。
    示例 1：
        输入：root = [1,2,3]
        输出：6
        解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    示例 2：
        输入：root = [-10,9,20,null,null,15,7]
        输出：42
        解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
    提示：
        树中节点数目范围是 [1, 3 * 10^4]
        -1000 <= Node.val <= 1000
 */
public class Question_124 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // 当前节点有四个选择：
        // 1）独立成线，直接返回自己的值
        // 2）跟左子节点合成一条路径
        // 3）跟右子节点合成一条路径
        int max = Math.max(root.val, root.val + Math.max(left,right));

        // 4）以自己为桥梁，跟左、右子节点合并成一条路径
        result = Math.max(result, Math.max(max, root.val + left + right));

        return max;
    }
}
