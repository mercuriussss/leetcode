package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.Stack;

/*
    问题描述：
        请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    示例：
        输入：

             4
           /   \
          2     7
         / \   / \
        1   3 6   9

        输出：

             4
           /   \
          7     2
         / \   / \
        9   6 3   1

    示例：
        输入：root = [4,2,7,1,3,6,9]
        输出：[4,7,2,9,6,3,1]
    限制：
        0 <= 节点个数 <= 1000
 */
public class Sword_27 {

    // 递归法
    // 时间复杂度O(N)，空间复杂度O(N)，N为二叉树节点数
    public TreeNode solution1(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = solution1(root.right);
        root.right = solution1(tmp);
        return root;
    }

    // 迭代法
    // 时间复杂度O(N)，空间复杂度O(N)，N为二叉树节点数
    public TreeNode solution2(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>(){{ add(root); }};
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
