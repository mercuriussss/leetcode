package com.cjl.leetcode;

import java.util.Arrays;

/*
    136. 只出现一次的数字
    问题描述：
        给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
    示例 1 ：
        输入：nums = [2,2,1]
        输出：1
    示例 2 ：
        输入：nums = [4,1,2,1,2]
        输出：4
    示例 3 ：
        输入：nums = [1]
        输出：1
    提示：
        1 <= nums.length <= 3 * 10^4
        -3 * 10^4 <= nums[i] <= 3 * 10^4
        除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class Question_136 {

    // 排序算法（不满足时间复杂度为O(N)）
    // 时间复杂度是O(NlogN)，空间复杂度是O(1)
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    // 异或算法
    // 任何数和0做异或运算都等于自身，任何数和自身做异或运算都等于0，异或运算满足交换律和结合律
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution2(int[] nums) {
        int res = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }
}
