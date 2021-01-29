package com.cjl.sword;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    问题描述：
        在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例1:
        s = "abaccdeff"
        返回 "b"
    示例2:
        s = ""
        返回 " "
    限制：
        0 <= s 的长度 <= 50000
 */
public class Solution_50 {

    // 哈希表解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public char solution1(String s){
        if(s == null || s.length() <= 0){
            return ' ';
        }
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map.put(c,!map.containsKey(c));
        }
        for (Map.Entry<Character,Boolean> d : map.entrySet()){
            if(d.getValue()){
                return d.getKey();
            }
        }
        return ' ';
    }

    // 数组解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public char solution2(String s){
        if(s == null || s.length() <= 0){
            return ' ';
        }
        int[] letters = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            letters[c - 'a']++;
        }
        // 按照字符串顺序遍历记录的数组
        for (int i = 0; i < s.length(); i++) {
            if(letters[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
