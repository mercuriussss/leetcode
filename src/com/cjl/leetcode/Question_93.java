package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    93. 复原 IP 地址
    问题描述：
        给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
        有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
        例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    示例 1：
        输入：s = "25525511135"
        输出：["255.255.11.135","255.255.111.35"]
    示例 2：
        输入：s = "0000"
        输出：["0.0.0.0"]
    示例 3：
        输入：s = "1111"
        输出：["1.1.1.1"]
    示例 4：
        输入：s = "010010"
        输出：["0.10.0.10","0.100.1.0"]
    示例 5：
        输入：s = "101023"
        输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    提示：
        0 <= s.length <= 3000
        s 仅由数字组成
 */
public class Question_93 {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> solution1(String s) {
        if (s.length() > 12) {
            return res;
        }
        sb.append(s);
        backTrack(sb, 0, 0);
        return res;
    }

    private void backTrack(StringBuilder sb, int start, int pointNum) {
        // 逗号数量为3时，分隔结束
        if (pointNum == 3) {
            if (isValid(sb.substring(start, sb.length()))) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < sb.length(); i++) {
            if (isValid(sb.substring(start, i + 1))) {
                // 在str的后⾯插⼊⼀个逗点
                sb.insert(i + 1, '.');
                // 插入逗号后，下一个子串的起始位置是i+2
                backTrack(sb, i + 2, pointNum + 1);
                // 回溯删去逗号
                sb.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        // 以0为开头的数字不合法
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            // 遇到非数字字符则不合法
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (str.charAt(i) - '0');
            // 大于255则不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
