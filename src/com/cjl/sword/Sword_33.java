package com.cjl.sword;

import java.util.Stack;

/*
    问题描述：
        输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
        如果是则返回 true，否则返回 false。
        假设输入的数组的任意两个数字都互不相同。
        参考以下这颗二叉搜索树：

                 5
                / \
               2   6
              / \
             1   3

    示例 1：
        输入: [1,6,3,2,5]
        输出: false
    示例 2：
        输入: [1,3,2,6,5]
        输出: true
    提示：
        数组长度 <= 1000
 */
public class Sword_33 {

    // 递归分治法
    // 时间复杂度O(N^2)，空间复杂度O(N)
    public boolean solution1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int pt = start;
        while (postorder[pt] < postorder[end]) {
            pt++;
        }
        int mid = pt;
        while (postorder[pt] > postorder[end]) {
            pt++;
        }
        return pt == end && recur(postorder, start, mid - 1) && recur(postorder, mid, end - 1);
    }

    // 辅助单调栈法
    // 二叉搜索树满足 max(left)<root<min(right) 条件
    // 时间复杂度O(N)，空间复杂度O(N)
    public boolean solution2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
