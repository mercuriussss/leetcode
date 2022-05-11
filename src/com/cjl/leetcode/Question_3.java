package com.cjl.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    3. 无重复字符的最长子串
    问题描述：
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1：
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2：
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
    示例 4:
        输入: s = ""
        输出: 0
    提示：
        0 <= s.length <= 5 * 10^4
        s 由英文字母、数字、符号和空格组成
 */
public class Question_3 {

    // 滑动窗口
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public static int solution1(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)), left);
            }
            map.put(s.charAt(i), i + 1);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    // set解法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution2(String s){
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(left < s.length() && right < s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }else{
                set.add(s.charAt(right++));
                max = Math.max(max,right - left);
            }
        }
        return max;
    }
}
