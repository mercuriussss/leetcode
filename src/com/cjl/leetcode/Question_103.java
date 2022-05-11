package com.cjl.leetcode;

import com.cjl.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
    103. 二叉树的锯齿形层序遍历
    问题描述：
        给定一个二叉树，返回其节点值的锯齿形层序遍历。
        （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    例如：
        给定二叉树[3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    返回锯齿形层序遍历如下：
        [
          [3],
          [20,9],
          [15,7]
        ]
 */
public class Question_103 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public List<List<Integer>> solution1(TreeNode root) {
        // LinkedList插入的时候时间复杂度O(1)，ArrayList插入时间复杂度O(n-k)
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) {
            return;
        }

        if(res.size() == level) {
            res.add(new LinkedList<>());
        }

        // 判断层数的奇偶数，奇数从右到左添加，偶数从左到右添加
        if((level & 1) == 1) {
            res.get(level).add(0,root.val);
        }else {
            res.get(level).add(root.val);
        }

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
