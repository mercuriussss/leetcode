package com.cjl.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    16. 最接近的三数之和
    问题描述：
        给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
        返回这三个数的和。
        假定每组输入只存在恰好一个解。
    示例 1：
        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    示例 2：
        输入：nums = [0,0,0], target = 1
        输出：0
    提示：
        3 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
        -10^4 <= target <= 10^4

 */
public class Question_16 {

    // 时间复杂度是O(N^2)，空间复杂度是O(1)
    public int solution1(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                int sum = nums[i] + nums[left++] + nums[right--];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum < target) {
                    left++;
                }else if (sum > target) {
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
