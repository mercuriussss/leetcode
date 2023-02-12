package com.cjl.leetcode;

/*
    42. 接雨水
    问题描述：
        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    示例 1：
        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    示例 2：
        输入：height = [4,2,0,3,2,5]
        输出：9
    提示：
        n == height.length
        0 <= n <= 3 * 10^4
        0 <= height[i] <= 10^5
 */
public class Question_42 {

    // 按列求法
    // 时间复杂度是O(N^2)，空间复杂度是O(1)
    public int solution1(int[] height) {
        int sum = 0;
        // 去掉头尾两端的列
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 木桶效应，两者取其短
            int min = Math.min(maxLeft, maxRight);
            // 最短的要大于当前列才能蓄水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    // 时间换空间，动态规划
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if(min > height[i]){
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    // 双指针
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution3(int[] height){
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if(height[left - 1] < height[right + 1]){
                max_left = Math.max(max_left,height[left - 1]);
                int min = max_left;
                if(min > height[left]){
                    sum += min - height[left];
                }
                left++;
            }else{
                max_right = Math.max(max_right,height[right + 1]);
                int min = max_right;
                if(min > height[right]){
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
