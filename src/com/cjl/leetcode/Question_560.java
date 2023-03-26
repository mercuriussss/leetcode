package com.cjl.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    560. 和为 K 的子数组
    问题描述：
        给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
    示例 1：
        输入：nums = [1,1,1], k = 2
        输出：2
    示例 2：
        输入：nums = [1,2,3], k = 3
        输出：2
    提示：
        1 <= nums.length <= 2 * 10^4
        -1000 <= nums[i] <= 1000
        -10^7 <= k <= 10^7
 */
public class Question_560 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(int[] nums, int k) {
        int countNum = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>() {{
            put(0, 1);
        }};
        for (int num : nums) {
            sum += num;
            // 如果sum-k包含在前N个数之和的数据中，那说明 sum - 前N个数之和 = k
            if (map.containsKey(sum - k)) {
                countNum += map.get(sum - k);
            }
            // 保存前N个数之和
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return countNum;
    }
}
