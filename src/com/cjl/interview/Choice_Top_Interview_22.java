package com.cjl.interview;

import com.cjl.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    问题描述：
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：
        输入：n = 1
        输出：["()"]
    提示：
        1 <= n <= 8
 */
public class Choice_Top_Interview_22 {

    public List<String> solution1(int n) {
        List<String> res = new ArrayList<>();
        recur(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    // count1代表"("的数量，count2代表")"的数量
    private void recur(List<String> res, StringBuilder ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            res.add(ans.toString());
        }
        if (count1 >= count2) {
            recur(res, ans.append("("), count1 + 1, count2, n);
            ans.deleteCharAt(ans.length() - 1);
            recur(res, ans.append(")"), count1, count2 + 1, n);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}
