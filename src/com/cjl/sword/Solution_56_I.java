package com.cjl.sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    问题描述：
        一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    示例 1：
        输入：nums = [4,1,4,6]
        输出：[1,6] 或 [6,1]
    示例 2：
        输入：nums = [1,2,10,4,1,4,3,3]
        输出：[2,10] 或 [10,2]
    限制：
        2 <= nums.length <= 10000
 */
public class Solution_56_I {

    // 位运算
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public static int[] solution1(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
        while ((n & m) == 0) {
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
