package com.cjl.leetcode;

/*
    31. 下一个排列
    问题描述：
            实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
            如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
            必须 原地 修改，只允许使用额外常数空间。
    示例 1：
        输入：nums = [1,2,3]
        输出：[1,3,2]
    示例 2：
        输入：nums = [3,2,1]
        输出：[1,2,3]
    示例 3：
        输入：nums = [1,1,5]
        输出：[1,5,1]
    示例 4：
        输入：nums = [1]
        输出：[1]
    提示：
        1 <= nums.length <= 100
        0 <= nums[i] <= 100
 */
public class Question_31 {

    // 时间复杂度是O(N)，空间复杂度是O(1)
    public void solution1(int[] nums) {
        int i,j;
        // 遍历找出第一对不满足降序的数字
        for (i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]){
                break;
            }
        }

        // 若i == -1，则证明该排序是降序的，反转即可
        if(i != -1) {
            // 否则，从降序序列的最右边开始寻找第一个比nums[i]大的数字
            for (j = nums.length - 1; j > 0; j--) {
                if(nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            i++;
        }else {
            i = 0;
        }

        // 从 i 开始到数组结束，这部分排序是降序状态，只需反转即可得到最小的数字
        j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }
}
