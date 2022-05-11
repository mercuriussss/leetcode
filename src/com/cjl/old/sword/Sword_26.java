package com.cjl.old.sword;

import com.cjl.common.TreeNode;

/*
    问题描述：
        输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
        例如:
        给定的树 A:

             3
            / \
           4   5
          / \
         1   2

        给定的树 B：

           4 
          /
         1

        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

    示例1：
        输入：A = [1,2,3], B = [3,1]
        输出：false
    示例2：
        输入：A = [3,4,5,1,2], B = [4,1]
        输出：true
    限制：
        0 <= 节点个数 <= 10000
 */
public class Sword_26 {

    // 通过先序遍历来判断是否符合条件
    // 时间复杂度O(MN)，空间复杂度O(M)，M为A节点数，N为B节点数
    public boolean solution1(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 判断B树是否是A树的根子树的一部分
        if(A.val == B.val && (recur(A.left,B.left) && recur(A.right,B.right))){
            return true;
        }
        // 判断B树是否是A树的左子树的一部分，或者是右子树的一部分
        return solution1(A.left,B) || solution1(A.right,B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val == B.val){
            return recur(A.left,B.left) && recur(A.right,B.right);
        }else{
            return false;
        }
    }
}
