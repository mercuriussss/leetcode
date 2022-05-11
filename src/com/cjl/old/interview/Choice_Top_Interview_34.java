package com.cjl.old.interview;

/*
    问题描述：
        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回[-1, -1]。
        进阶：
        你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
    示例 1：
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
    示例2：
        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]
    示例 3：
        输入：nums = [], target = 0
        输出：[-1,-1]
    提示：
        0 <= nums.length <= 10^5
        -10^9<= nums[i]<= 10^9
        nums是一个非递减数组
        -10^9<= target<= 10^9
 */
public class Choice_Top_Interview_34 {

    // 时间复杂度是O(logN),空间复杂度是O(1)
    public int[] solution1(int[] nums, int target) {
        // 去除掉数组为空，还有 target 超出数组大小范围的情况
        if (nums == null || nums.length == 0 || nums[nums.length - 1] < target || nums[0] > target) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                // 向前遍历，找出起始位置
                while (--start >= left && nums[start] == target){}
                // 向后遍历，找出终止位置
                while (++end <= right && nums[end] == target){}
                return new int[]{start + 1, end - 1};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
