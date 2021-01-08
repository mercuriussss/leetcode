package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    问题描述：
        请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
          [20,9],
          [15,7]
        ]

    提示：
        节点总数 <= 1000
 */
public class Solution_32_III {

    // 层序遍历，BFS
    // 时间复杂度O(N)，空间复杂度O(N)
    public List<List<Integer>> solution1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0){   // 偶数层 -> 顺序添加
                    tmp.addLast(node.val);
                }else{  // 奇数层 -> 倒序添加
                    tmp.addFirst(node.val);
                }
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
    public List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res, true);
        return res;
    }

    private void dfs(int depth, TreeNode root, List<List<Integer>> res,boolean order) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        if(order){
            res.get(depth).add(root.val);
        }else{
            res.get(depth).add(0,root.val);
        }
        dfs(depth + 1, root.left, res, !order);
        dfs(depth + 1, root.right, res, !order);
    }
}
