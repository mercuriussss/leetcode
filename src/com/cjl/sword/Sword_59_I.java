package com.cjl.sword;

import java.util.Deque;
import java.util.LinkedList;

/*
    问题描述：
        给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

    示例:
        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
        输出: [3,3,5,5,6,7]
        解释:
          滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7
    提示：
        你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class Sword_59_I {

    // 暴力破解法
    // 时间复杂度是O(Nk)，空间复杂度是O(k)
    public int[] solution1(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        int count = 0;
        while(right < nums.length){
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if(nums[i] > max){
                    max = nums[i];
                }
            }
            res[count++] = max;
            left ++;
            right ++;
        }
        return res;
    }

    // 单调队列
    // 时间复杂度是O(N)，空间复杂度是O(k)
    public int[] solution2(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 删除掉 deque 中比当前值更小的值
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[index++] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // i - k 是已经在窗口外了,需要删除掉队列中对应的 nums[i - k]
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            // 删除掉队列中比当前值更大的值，保持队列递减
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }
}
