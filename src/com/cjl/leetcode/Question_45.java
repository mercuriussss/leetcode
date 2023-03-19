package com.cjl.leetcode;



/*
    45. 跳跃游戏 II
    问题描述：
        给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
        0 <= j <= nums[i]
        i + j < n
        返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
    示例 1:
        输入: nums = [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
             从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    示例 2:
        输入: nums = [2,3,0,1,4]
        输出: 2
    提示:
        1 <= nums.length <= 10^4
        0 <= nums[i] <= 1000
        题目保证可以到达 nums[n-1]

 */
public class Question_45 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution1(int[] nums) {
        int count = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 下一步能跳的最大距离
            farthest = Math.max(farthest, nums[i] + i);
            // 下一步能跳到终点，结束
            if (farthest >= nums.length - 1) {
                count++;
                break;
            }
            // 当前位置是否等于当前能跳到的最远位置，等于了说明需要再跳一次
            // 例如从0能跳到3，那么中间的1和2就被包括在内，当遍历到1和2时不需要加一次跳的次数，等抵达3时才要加一次
            if (i == end) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}