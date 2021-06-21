package com.cjl.old.sword;

import com.cjl.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    问题描述：
        从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    例如:
        给定二叉树: [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7

    返回：

        [
          [3],
          [9,20],
          [15,7]
        ]

    提示：
        节点总数 <= 1000
 */
public class Sword_32_II {

    // 迭代法，BFS
    // 时间复杂度O(N)，空间复杂度O(N)
    public List<List<Integer>> solution1(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    // 递归法，DFS
    // 时间复杂度O(N)，空间复杂度O(N)
    public List<List<Integer>> solution2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    private void dfs(int depth, TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        dfs(depth + 1, root.left, res);
        dfs(depth + 1, root.right, res);
    }
}
