package com.cjl.sword;

/*
    问题描述：
        我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    示例:
        输入: n = 10
        输出: 12
        解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    说明:
        1 是丑数。
        n 不超过1690。
 */
public class Solution_49 {

    // 动态规划,三指针
    // 时间复杂度O(N)，空间复杂度O(N)
    public int solution1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘2来得到下个丑数，同理第c个数
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
