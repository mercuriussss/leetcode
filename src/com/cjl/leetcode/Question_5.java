package com.cjl.leetcode;

/*
    5. 最长回文子串
    问题描述：
        给你一个字符串 s，找到 s 中最长的回文子串。
    示例 1：
        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
    示例 2：
        输入：s = "cbbd"
        输出："bb"
    示例 3：
        输入：s = "a"
        输出："a"
    示例 4：
        输入：s = "ac"
        输出："a"
    提示：
        1 <= s.length <= 1000
        s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Question_5 {

    // 中心扩散法
    // 时间复杂度是O(N^2)，空间复杂度是O(1)
    public String solution1(String s){
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len;) {
            // 如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            if (len - i <= (end - start) / 2) {
                break;
            }
            int left = i;
            int right = i;
            // 从出发点往右去除掉重复项
            while(right < len - 1 && s.charAt(right + 1) == s.charAt(right)){
                right++;
            }
            // 下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            // 从中心往左右扩散
            while(left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)){
                left--;
                right++;
            }
            if(end - start < right - left){
                start = left;
                end = right;
            }
        }
        return s.substring(start,end + 1);
    }
}
