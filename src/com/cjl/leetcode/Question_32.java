package com.cjl.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/*
    32. 最长有效括号
    问题描述：
            给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    示例 1：
        输入：s = "(()"
        输出：2
        解释：最长有效括号子串是 "()"
    示例 2：
        输入：s = ")()())"
        输出：4
        解释：最长有效括号子串是 "()()"
    示例 3：
        输入：s = ""
        输出：0
        提示：
        0 <= s.length <= 3 * 10^4
        s[i] 为 '(' 或 ')'
 */
public class Question_32 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else{
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
