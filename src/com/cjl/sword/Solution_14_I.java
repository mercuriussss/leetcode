package com.cjl.sword;

/*
    问题描述：
      给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
      请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
      例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

    示例 1:
        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */

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
