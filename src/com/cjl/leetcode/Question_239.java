package com.cjl.leetcode;

import java.util.*;

/*
    239. 滑动窗口最大值
    难度：
        hard
    问题描述：
        给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        返回 滑动窗口中的最大值 。
    示例 1：
        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
    示例 2：
        输入：nums = [1], k = 1
        输出：[1]
    提示：
        1 <= nums.length <= 10^5
        -104 <= nums[i] <= 10^4
        1 <= k <= nums.length
 */
public class Question_239 {

    // 双向队列
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int[] solution1(int[] nums, int k) {
        // 双向队列，存放数据对应的数组下标
        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 如果队首元素已经不在滑动窗口内，则需要移除掉
            while (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 如果队尾元素比当前元素小，则需要移除掉
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前元素的下标加到队尾
            deque.offerLast(i);

            // 刚开始还没形成完整滑动窗口，所以需要跳过
            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
