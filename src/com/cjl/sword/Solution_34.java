package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
    问题描述：
        输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
        从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

    示例:
        给定如下二叉树，以及目标和 sum = 22，

                      5
                     / \
                    4   8
                   /   / \
                  11  13  4
                 /  \    / \
                7    2  5   1
    返回:
        [
           [5,4,11,2],
           [5,8,4,5]
        ]
    提示：
        节点总数 <= 10000
 */
public class Solution_34 {


    // 递归法，DFS
    // 时间复杂度O(N)，空间复杂度O(N)
    public List<List<Integer>> solution1(TreeNode root, int sum) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root,sum,res,path);
        return res;
    }

    private void dfs(TreeNode root, int target,LinkedList<List<Integer>> res,LinkedList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<>(path));
            return;
        }
        dfs(root.left,target,res,path);
        dfs(root.right,target,res,path);
        path.removeLast();
    }
}
