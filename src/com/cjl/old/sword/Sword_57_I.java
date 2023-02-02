package com.cjl.old.sword;

import java.util.HashSet;
import java.util.Set;

/*
    问题描述：
        输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
        如果有多对数字的和等于s，则输出任意一对即可。
    示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[2,7] 或者 [7,2]
    示例 2：
        输入：nums = [10,26,30,31,47,60], target = 40
        输出：[10,30] 或者 [30,10]
    限制：
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^6
 */
public class Sword_57_I {

    // 哈希法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int[] solution1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(target - num);
            } else {
                return new int[]{num, target - num};
            }
        }
        return new int[]{};
    }

    // 双指针
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int[] solution2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur == target) {
                return new int[]{nums[left], nums[right]};
            } else if (cur > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}