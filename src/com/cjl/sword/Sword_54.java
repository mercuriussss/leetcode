package com.cjl.sword;

import com.cjl.common.TreeNode;

/*
    问题描述：
        给定一棵二叉搜索树，请找出其中第k大的节点。
    示例 1:
        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 4
    示例 2:
        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 4
    限制：
        1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Sword_54 {

    // 二叉搜索树的中序遍历为递增序列，此方法为中序遍历倒序
    // 时间复杂度O(N)，空间复杂度O(N)
    int count = 0, res = 0;
    public int solution1(TreeNode root, int k) {
        this.count = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null || count == 0){
            return; // 当root为空或者已经找到res时，直接返回
        }
        dfs(root.right);
        if(--count == 0){
            res = root.val;
            return;     // 这里的return可以避免后续的无效迭代dfs(root.left)
        }
        dfs(root.left);
    }
}
