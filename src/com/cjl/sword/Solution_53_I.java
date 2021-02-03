package com.cjl.sword;

/*
    问题描述：
        统计一个数字在排序数组中出现的次数。
    示例 1:
        输入: nums = [5,7,7,8,8,10], target = 8
        输出: 2
    示例 2:
        输入: nums = [5,7,7,8,8,10], target = 6
        输出: 0
    限制：
        0 <= 数组长度 <= 50000
 */
public class Solution_53_I {

    // 二分法
    // 时间复杂度O(logN)，空间复杂度O(1)
    public int solution1(int[] nums,int target){
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    private int binarySearch(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) >>> 1;
            if(nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
