package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
    问题描述：
        输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    示例 1：
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：
            3
           / \
          9  20
            /  \
           15   7
    限制：
        0 <= 节点个数 <= 5000
 */

public class Sword_7 {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        Sword_7 rt = new Sword_7();
        TreeNode root = rt.buildTree(preOrder,inOrder);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preOrder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return buildTree(preOrder, 0, length - 1, inOrder, 0, length - 1, indexMap);
    }
    public TreeNode buildTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd, Map<Integer, Integer> indexMap) {
        if(preOrderStart > preOrderEnd){
            return null;
        }
        int rootVal = preOrder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);
        if(preOrderStart == preOrderEnd){
            return root;
        }else{
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inOrderStart;
            int rightNodes = inOrderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preOrder, preOrderStart + 1, preOrderStart + leftNodes, inOrder, inOrderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preOrder, preOrderEnd - rightNodes + 1, preOrderEnd, inOrder, rootIndex + 1, inOrderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}