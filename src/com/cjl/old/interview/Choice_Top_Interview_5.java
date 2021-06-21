package com.cjl.old.interview;

/*
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
public class Choice_Top_Interview_5 {

    // 中心扩散法
    // 时间复杂度是O(N^2)，空间复杂度是O(1)
    public String solution1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private int findLongest(char[] str, int low, int[] range) {
        int high = low;
        // 查找中间部分
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int res = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return res;
    }


    // 中心扩散法
    // 时间复杂度是O(N^2)，空间复杂度是O(1)
    public String solution2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, maxLen = 0;
        int len = s.length();
        for (int i = 0; i < len; ) {
            // 如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            if (len - i <= maxLen / 2) {
                break;
            }
            int left = i, right = i;
            while (right < len - 1 && s.charAt(right + 1) == s.charAt(right)) {
                //过滤掉重复的
                right++;
            }
            // 下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            // 往两边判断，找出回文子串的长度
            while (right < len - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                left--;
                right++;
            }
            // 保留最长的
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        return s.substring(start, maxLen);
    }
}
