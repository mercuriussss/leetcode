package com.cjl.leetcode;

/*
    14. 最长公共前缀
    问题描述：
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
    示例 1：
        输入：strs = ["flower","flow","flight"]
        输出："fl"
    示例 2：
        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。
    提示：
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] 仅由小写英文字母组成
 */
public class Question_14 {

    // 时间复杂度O(N^2)，空间复杂度O(1)
    public String solution1(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // substring 是左闭右开的
            res = res.substring(0, j);
            if (res.equals("")) {
                return res;
            }
        }
        return res;
    }
}
