package com.cjl.old.interview;

/*
    问题描述：
        给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
        '.' 匹配任意单个字符
        '*' 匹配零个或多个前面的那一个元素
        所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
    示例 1：
        输入：s = "aa" p = "a"
        输出：false
        解释："a" 无法匹配 "aa" 整个字符串。
    示例 2:
        输入：s = "aa" p = "a*"
        输出：true
        解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
    示例3：
        输入：s = "ab" p = ".*"
        输出：true
        解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
    示例 4：
        输入：s = "aab" p = "c*a*b"
        输出：true
        解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
    示例 5：
        输入：s = "mississippi" p = "mis*is*p*."
        输出：false
    提示：
        0 <= s.length<= 20
        0 <= p.length<= 30
        s可能为空，且只包含从a-z的小写字母。
        p可能为空，且只包含从a-z的小写字母，以及字符.和*。
        保证每次出现字符* 时，前面都匹配到有效的字符
 */
public class Choice_Top_Interview_10 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public boolean solution1(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for(int j = 2; j < n; j += 2) {
            // 首行 s 为空字符串，因此需要当 p 的偶数位为 * 时才能匹配首行
            // （根据题意，*只能出现在偶数位上）
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(p.charAt(j - 1) == '*') {
                    if(dp[i][j - 2]) {      // 将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配
                        dp[i][j] = true;
                    }else if(dp[i][j - 1]) {    // 将字符组合 p[j - 2] * 看作出现 1 次时，能否匹配
                        dp[i][j] = true;
                    }else if(dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {  // 让字符 p[j - 2] 出现 2 次时，能否匹配
                        dp[i][j] = true;
                    }else if(dp[i - 1][j] && p.charAt(j - 2) == '.') {  // 让字符 '.' 多出现 1 次时，能否匹配
                        dp[i][j] = true;
                    }
                } else {
                    if(dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {    // 让字符 p[j - 1] 多出现一次时，能否匹配
                        dp[i][j] = true;
                    }
                    else if(dp[i - 1][j - 1] && p.charAt(j - 1) == '.') {   // 将字符 . 看作字符 s[i - 1] 时，能否匹配
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
