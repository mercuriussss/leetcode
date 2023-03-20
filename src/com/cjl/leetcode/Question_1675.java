package com.cjl.leetcode;

import java.util.TreeSet;

/*
    1675. 数组的最小偏移量
    难度：
        hard
    问题描述：
        给你一个由 n 个正整数组成的数组 nums 。
        你可以对数组的任意元素执行任意次数的两类操作：
        如果元素是 偶数 ，除以 2
        例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
        如果元素是 奇数 ，乘上 2
        例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
        数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
        返回数组在执行某些操作之后可以拥有的 最小偏移量 。
    示例 1：
        输入：nums = [1,2,3,4]
        输出：1
        解释：你可以将数组转换为 [1,2,3,2]，然后转换成 [2,2,3,2]，偏移量是 3 - 2 = 1
    示例 2：
        输入：nums = [4,1,5,20,3]
        输出：3
        解释：两次操作后，你可以将数组转换为 [4,2,5,5,3]，偏移量是 5 - 2 = 3
    示例 3：
        输入：nums = [2,10,8]
        输出：3
    提示：
        n == nums.length
        2 <= n <= 5 * 10^4
        1 <= nums[i] <= 10^9
 */
public class Question_1675 {

    // 时间复杂度是O(NlogN)，空间复杂度是O(N)
    public int solution1(int[] nums) {
        // 创建大顶堆
        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> b - a);

        // 奇数乘以二，偶数不变，添加到大顶堆中
        for (int i = 0; i < nums.length; i++) {
            int tempNum = nums[i] % 2 == 0? nums[i] : nums[i] * 2;
            maxHeap.add(tempNum);
        }

        // 最小偏移量
        int minOffset = maxHeap.first() - maxHeap.last();

        // 当最大元素是偶数时，将其除以二再放回去，不断遍历处理
        while (minOffset > 0 && maxHeap.first() % 2 == 0) {
            int maxValue = maxHeap.first();
            maxHeap.remove(maxValue);
            maxHeap.add(maxValue / 2);
            minOffset = Math.min(minOffset, maxHeap.first() - maxHeap.last());
        }
        return minOffset;
    }
}
