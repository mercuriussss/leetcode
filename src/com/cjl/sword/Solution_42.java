package com.cjl.sword;

/*
    问题描述：
        输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
        要求时间复杂度为O(n)。
    示例1:
        输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    提示：
        1 <= arr.length <= 10^5
        -100 <= arr[i] <= 100
 */
public class Solution_42 {

    // 动态规划
    // 时间复杂度O(N)，空间复杂度O(1)
    public int solution1(int[] nums) {
        int max = nums[0];
        int pre = 0;     //用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int cur;        //用于记录dp[i]的值
        for (int num : nums) {
            cur = num;
            cur += Math.max(pre, 0);
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }
}
