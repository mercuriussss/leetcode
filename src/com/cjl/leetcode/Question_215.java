package com.cjl.leetcode;

import java.util.*;

/*
    215. 数组中的第K个最大元素
    问题描述：
        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
    示例 1:
        输入: [3,2,1,5,6,4], k = 2
        输出: 5
    示例 2:
        输入: [3,2,3,1,2,4,5,5,6], k = 4
        输出: 4
    提示：
        1 <= k <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4
 */
public class Question_215 {

    private final static Random random = new Random(System.currentTimeMillis());

    // 堆排序解法
    // 时间复杂度是O(NlogN)，空间复杂度是O(N)
    public int solution1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, Comparator.comparingInt(a -> a));
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    // 快速选择法
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public int solution2(int[] nums, int k) {
        // 将k转换为从左到右第几小的元素
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivotIdx = partition(nums, left, right);
            if (pivotIdx == k) {
                return nums[k];
            } else if(pivotIdx > k) {
                // 如果枢轴大于k，则说明第k小的元素在左侧，缩小右边界
                right = pivotIdx - 1;
            } else {
                // 如果枢轴小于k，则说明第k小的元素在右侧，缩小左边界
                left = pivotIdx + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        // 这里为了优化极端测试用例的时间复杂度，将最右边元素跟中间随机一个数交换
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, right, randomIndex);

        // 取最右边的元素(刚才随机交换的值)为枢轴
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            // 若当前元素小于或等于枢轴，则需要将它与i指向的元素交换位置，并且交换完后，i需要向前移动一位
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        // 最后将i指向的元素与枢轴交换，相当于把枢轴放到中间的分界点，并返回此时i作为新的枢轴位置
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
