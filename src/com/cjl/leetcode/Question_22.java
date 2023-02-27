package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    22. 括号生成
    问题描述：
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：
        输入：n = 1
        输出：["()"]
    提示：
        1 <= n <= 8
 */
public class Question_22 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public List<String> solution1(int n) {
        List<String> res = new ArrayList<>();
        recur(res, "", 0, 0, n);
        return res;
    }

    /**
     *
     * @param res 返回结果
     * @param str 括号组合字符串
     * @param leftNum 左括号数量
     * @param rightNum 右括号数量
     * @param n 总对数
     */
    private void recur(List<String> res, String str, int leftNum, int rightNum, int n) {
        if (leftNum > n || rightNum > n) {
            return;
        }
        if (leftNum == n && rightNum == n) {
            res.add(str);
        }
        if (leftNum >= rightNum) {
            recur(res, str + "(", leftNum + 1, rightNum, n);
            recur(res, str + ")", leftNum, rightNum + 1, n);
        }
    }
}
