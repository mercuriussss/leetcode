package com.cjl.sword;

import java.util.HashMap;
import java.util.Map;

/*
    问题描述：
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    示例 1:
        输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
        输出: 2
    限制：
        1 <= 数组长度 <= 50000
 */
public class Solution_39 {

    // 哈希表统计法
    // 时间复杂度O(N)，空间复杂度O(N)
    public int solution1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n) {
                return num;
            }
        }
        return 0;
    }

    // 摩尔投票法
    // 时间复杂度O(N)，空间复杂度O(1)
    public int solution2(int[] nums) {
        int target = 0;
        int votes = 0;
        int count = 0;
        for (int num : nums) {
            if (votes == 0) {
                target = num;
            }
            votes += num == target ? 1 : -1;
        }
        // 验证target是否为众数
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        // 无众数时返回0
        return count > nums.length / 2 ? target : 0;
    }
}
