package com.cjl.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    4. 寻找两个正序数组的中位数
    问题描述：
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    示例 1：
        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
    示例 2：
        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
    示例 3：
        输入：nums1 = [0,0], nums2 = [0,0]
        输出：0.00000
    示例 4：
        输入：nums1 = [], nums2 = [1]
        输出：1.00000
    示例 5：
        输入：nums1 = [2], nums2 = []
        输出：2.00000
    提示：
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -10^6 <= nums1[i], nums2[i] <= 10^6
    进阶：
        你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Question_4 {

    // 遍历求中位数法
    // 时间复杂度是O(M+N)，空间复杂度是O(1)
    public double solution1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int left = -1;
        int right = -1;
        int nums1Start = 0;
        int nums2Start = 0;
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if(nums1Start < nums1.length && (nums2Start >= nums2.length || nums1[nums1Start] < nums2[nums2Start])){
                right = nums1[nums1Start++];
            }else{
                right = nums2[nums2Start++];
            }
        }
        if((len & 1) == 0){
            return (left + right)/2.0;
        }else{
            return right;
        }
    }

    // 二分查找法求中位数
    // 时间复杂度是O(log(M+N))，空间复杂度是O(1)
    public double solution2(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1)/2;
        int right = (len1 + len2 + 2)/2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private int findKth(int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k) {
        if (nums1Start >= nums1.length) {
            //nums1为空数组
            return nums2[nums2Start + k - 1];
        }
        if (nums2Start >= nums2.length) {
            //nums2为空数组
            return nums1[nums1Start + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[nums1Start], nums2[nums2Start]);
        }
        int midVal1 = (nums1Start + k / 2 - 1 < nums1.length) ? nums1[nums1Start + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (nums2Start + k / 2 - 1 < nums2.length) ? nums2[nums2Start + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, nums1Start + k / 2, nums2, nums2Start, k - k / 2);
        } else {
            return findKth(nums1, nums1Start, nums2, nums2Start + k / 2, k - k / 2);
        }
    }
}
