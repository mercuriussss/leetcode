package com.cjl.old.interview;

import java.util.ArrayList;
import java.util.List;

/*
    问题描述：
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    示例 1：
        输入：digits = "23"
        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    示例 2：
        输入：digits = ""
        输出：[]
    示例 3：
        输入：digits = "2"
        输出：["a","b","c"]
    提示：
        0 <= digits.length <= 4
        digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Choice_Top_Interview_17 {

    public List<String> solution1(String digits) {
        List<String> result = new ArrayList<>();
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            result = combination(result, str[digits.charAt(i) - '0' - 2]);
        }
        return result;
    }

    public List<String> combination(List<String> s1, String s2) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            if (s1.isEmpty()) {
                str.add(s2.substring(i, i + 1));
            } else {
                for (String s : s1) {
                    str.add(s + s2.substring(i, i + 1));
                }
            }
        }
        return str;
    }
}
