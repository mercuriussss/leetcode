package com.cjl.sword;

/*
    问题描述：
        给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
        一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
    示例 1:
        输入: 12258
        输出: 5
        解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
    提示：
        0 <= num < 231
 */
public class Sword_46 {

    // 动态规划，字符串遍历
    // 时间复杂度O(N)，空间复杂度O(N)
    public int solution1(int num){
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2,i);
            if(tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    // 递归法
    // 时间复杂度O(2^N)，空间复杂度O(N)
    public int solution2(int num){
        if(num <= 9){
            return 1;
        }
        //xyzcba
        int ba = num%100;
        if(ba <= 9 || ba >=26){
            return solution2(num/10);
        }else{
            return solution2(num/10) + solution2(num/100);
        }
    }
}
