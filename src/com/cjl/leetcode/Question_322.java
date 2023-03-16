package com.cjl.leetcode;


import java.util.Arrays;

/*
    322. 零钱兑换
    问题描述：
        给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        你可以认为每种硬币的数量是无限的。
    示例 1：
        输入：coins = [1, 2, 5], amount = 11
        输出：3
        解释：11 = 5 + 5 + 1
    示例 2：
        输入：coins = [2], amount = 3
        输出：-1
    示例 3：
        输入：coins = [1], amount = 0
        输出：0
    提示：
        1 <= coins.length <= 12
        1 <= coins[i] <= 2^31 - 1
        0 <= amount <= 10^4

 */
public class Question_322 {

    // 动态数组
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(int[] coins, int amount) {
        // 该数组下标代表金额，值则代表凑成该金额的最少硬币数量
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, amount + 1,Integer.MAX_VALUE);
        for (int coin : coins) {
            // 对于每个硬币面额 coin，从 coin 到 amount 的范围内，更新dp数组
            for (int i = coin; i <= amount; i++) {
                // 若dp[i-coin]不等于初始值，则表示可以使用该硬币
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    // 这里的 dp[i-coin]+1 代表 i-coin 面额的硬币最少数量，再加上一个 coin 硬币面额的硬币
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
