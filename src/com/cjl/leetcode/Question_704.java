package com.cjl.leetcode;

/*
    20. 有效的括号
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    示例 1:
        输入: nums = [-1,0,3,5,9,12], target = 9
        输出: 4
        解释: 9 出现在 nums 中并且下标为 4
    示例 2:
        输入: nums = [-1,0,3,5,9,12], target = 2
        输出: -1
        解释: 2 不存在 nums 中因此返回 -1
    提示：
        你可以假设 nums 中的所有元素是不重复的。
        n 将在 [1, 10000]之间。
        nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Question_704 {

    // 遍历法
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 递归处理法
    // 时间复杂度O(nlogn)，空间复杂度O(N)
    public int solution2(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return -1;
        }
        return findTarget(nums, 0, nums.length - 1, target);
    }

    public int findTarget(int[] nums, int left, int right, int target) {
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }

        if (left == right || right - left == 1) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] < target) {
            return findTarget(nums, mid, right, target);
        } else {
            return findTarget(nums, left, mid, target);
        }
    }
}
