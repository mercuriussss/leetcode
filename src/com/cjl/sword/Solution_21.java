package com.cjl.sword;

/*
    问题描述：
        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    示例：
        输入：nums = [1,2,3,4]
        输出：[1,3,2,4]
        注：[3,1,2,4] 也是正确的答案之一。
    提示：
        1 <= nums.length <= 50000
        1 <= nums[i] <= 10000
 */
public class Solution_21 {

    // 首尾双指针解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public int[] solution1(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int tmp;
        while(left < right) {
            // x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
            while(left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while(left < right && (nums[right] & 1) == 0) {
                right--;
            }
            tmp = nums[left];
            nums[left++] = nums[right];   // 交换后的left肯定为奇数，right肯定为偶数，可以将该两个值忽略掉，减少2次遍历
            nums[right--] = tmp;
        }
        return nums;
    }

    // 快慢双指针解法
    // 时间复杂度O(N)，空间复杂度O(1)
    public int[] solution2(int[] nums){
        int low = 0;
        int fast = 0;
        int tmp;
        while(fast < nums.length){
            if((nums[fast] & 1) == 1){
                tmp = nums[fast];
                nums[fast] = nums[low];
                nums[low++] = tmp;
            }
            fast ++;
        }
        return nums;
    }
}
