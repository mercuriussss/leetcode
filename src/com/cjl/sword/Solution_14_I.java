package com.cjl.sword;

public class Solution_14_I {
    public int cuttingRope(int n) {
        return solution1(n);
    }

    // 用数学推导法推导出每段分成3的乘积会更高
    public int solution1(int n){
        if(n <= 3){
            return n - 1;
        }
        int a = n/3;
        int b = n%3;
        if(b == 0){
            return (int)Math.pow(3,a);
        }
        if(b == 1){
            return (int)Math.pow(3,a-1)*4;
        }
        return (int)Math.pow(3,a)*2;
    }

    // 使用动态规划的方法
    public int solution2(int n){
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]= Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
