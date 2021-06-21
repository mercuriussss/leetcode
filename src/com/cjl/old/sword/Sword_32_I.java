package com.cjl.old.sword;

import com.cjl.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    问题描述：
        从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    例如:
        给定二叉树: [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7

    返回：
        [3,9,20,15,7]

    提示：
        节点总数 <= 1000
 */
public class Sword_32_I {

    // 时间复杂度O(N)，空间复杂度O(N)
    public int[] solution1(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
