package com.cjl.old.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    问题描述：
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    示例 4:
        输入: s = ""
        输出: 0
    提示：
        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成
 */
public class Choice_Top_Interview_3 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)), left);
            }
            res = Math.max(res, i - left + 1);
            map.put(s.charAt(i), i + 1);
        }
        return res;
    }

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution2(String s) {
        int len = s.length();
        int res = 0;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (start < len && end < len) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }
}
