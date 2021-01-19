package com.cjl.sword;

import com.cjl.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    问题描述：
        请实现两个函数，分别用来序列化和反序列化二叉树。
    示例: 
        你可以将以下二叉树：

            1
           / \
          2   3
             / \
            4   5

        序列化为 "[1,2,3,null,null,4,5]"
 */
public class Solution_37 {

    // 时间复杂度O(N)，空间复杂度O(N)
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                res.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            } else {
                res.add(null);
            }
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).replaceAll("\\s", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
