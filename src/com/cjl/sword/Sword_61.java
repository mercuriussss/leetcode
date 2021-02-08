package com.cjl.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    问题描述：
        从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    示例 1:
        输入: [1,2,3,4,5]
        输出: True
    示例 2:
        输入: [0,0,1,2,5]
        输出: True
    限制：
        数组长度为 5 
        数组的数取值为 [0, 13]
 */
public class Sword_61 {

    // 集合+遍历
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public boolean solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue; // 跳过大小王
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) {
                return false;   // 若出现重复则返回 false
            }
            set.add(num);
        }
        return max - min < 5;   // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    // 集合+遍历
    // 时间复杂度是O(NlogN)，空间复杂度是O(1)
    public boolean solution2(int[] nums) {
        int jokers = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                jokers++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[jokers] < 5;  // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
