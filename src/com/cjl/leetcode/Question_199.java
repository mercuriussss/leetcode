package com.cjl.leetcode;

import com.cjl.common.ListNode;
import com.cjl.common.TreeNode;

import java.util.*;
import java.util.concurrent.BlockingDeque;

/*
    199. 二叉树的右视图
    问题描述：
        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    示例 1:
        输入:[1,2,3,null,5,null,4]
        输出:[1,3,4]
    示例 2:
        输入:[1,null,3]
        输出:[1,3]
    示例 3:
        输入:[]
        输出:[]
    提示:
        二叉树的节点个数的范围是 [0,100]
        -100<= Node.val <= 100
 */
public class Question_199 {

    // DFS 深度遍历算法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public List<Integer> solution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root,0,res);
        return res;
    }

    private void recur(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
          return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (level == res.size()) {
          // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
          res.add(root.val);
        }
        level++;
        recur(root.right, level, res);
        recur(root.left, level, res);
    }

    // BFS 广度遍历算法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public List<Integer> solution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if(i == size - 1) {
                    // 当前层最后一个节点存入数据
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
