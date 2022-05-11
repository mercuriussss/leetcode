package com.cjl.old.sword;

import java.util.HashMap;
import java.util.Map;

/*
    问题描述：
        在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    示例 1：
        输入：nums = [3,4,3,3]
        输出：4
    示例 2：
        输入：nums = [9,1,7,9,7,9,7]
        输出：1
    限制：
        1 <= nums.length <= 10000
        1 <= nums[i] < 2^31
 */
public class Sword_56_II {

    // 哈希表法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int target = 0;
        for (int num : nums) {
            if (map.get(num) == 1) {
                target = num;
            }
        }
        return target;
    }

    // 遍历法
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution2(int[] nums){
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;     // m表示除了一个数字以外，其余数字都出现m次的情况
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    // 有限状态自动机
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution3(int[] nums){
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
