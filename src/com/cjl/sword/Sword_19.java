package com.cjl.sword;

/*
    问题描述：
        请实现一个函数用来匹配包含'. '和'*'的正则表达式。
        模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
        在本题中，匹配是指字符串的所有字符匹配整个模式。
        例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
    示例 1:
        输入:
            s = "aa"
            p = "a"
        输出: false
        解释: "a" 无法匹配 "aa" 整个字符串。
    示例 2:
        输入:
            s = "aa"
            p = "a*"
        输出: true
        解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
    示例 3:
        输入:
            s = "ab"
            p = ".*"
        输出: true
        解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
    示例 4:
        输入:
            s = "aab"
            p = "c*a*b"
        输出: true
        解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

    ⊙ s 可能为空，且只包含从 a-z 的小写字母。
    ⊙ p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。

 */
public class Sword_19 {

    // 动态规划，时间复杂度O(MN)，M、N分别为s和p的长度，空间复杂度O(MN)
    public boolean solution1(String s,String p){
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for(int j = 2; j < n; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // 状态转移
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(p.charAt(j - 1) == '*') {
                    if(dp[i][j - 2]) {
                        dp[i][j] = true;
                    }else if(dp[i][j - 1]) {
                        dp[i][j] = true;
                    }else if(dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = true;
                    }else if(dp[i - 1][j] && p.charAt(j - 2) == '.') {
                        dp[i][j] = true;
                    }
                } else {
                    if(dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                    else if(dp[i - 1][j - 1] && p.charAt(j - 1) == '.') {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public boolean solution2(String str,String reg){
        int n = str.length();
        int m = reg.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (reg.charAt(j - 1) != '*') {
                        if (i > 0 && (str.charAt(i - 1) == reg.charAt(j - 1) || reg.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (str.charAt(i - 1) == reg.charAt(j - 2) || reg.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
