package com.cjl.interview;

/*
    问题描述：
        整数数组 nums 按升序排列，数组中的值互不相同 。
        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
        nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
        例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
        给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回-1。
    示例 1：
        输入：nums = [4,5,6,7,0,1,2], target = 0
        输出：4
    示例2：
        输入：nums = [4,5,6,7,0,1,2], target = 3
        输出：-1
    示例 3：
        输入：nums = [1], target = 0
        输出：-1
    提示：
        1 <= nums.length <= 5000
        -10^4 <= nums[i] <= 10^4
        nums 中的每个值都 独一无二
        nums 肯定会在某个点上旋转
        -10^4 <= target <= 10^4
 */
public class Choice_Top_Interview_33 {

    // 时间复杂度是O(logN),空间复杂度是O(1)
    public int solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){  // 如果中间的数小于最右边的数，则右半段是有序的
                if(nums[mid] < target && target < nums[right]){
                    left = mid - 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[left] <= target && target < nums[mid]){ // 若中间数大于最右边数，则左半段是有序的
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
