package com.cjl.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    问题描述：
        给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
        请你找出所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
    示例 1：
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
    示例 2：
        输入：nums = []
        输出：[]
    示例 3：
        输入：nums = [0]
        输出：[]
    提示：
        0 <= nums.length <= 3000
        -10^5 <= nums[i] <= 10^5
 */
public class Choice_Top_Interview_14 {

    // 时间复杂度是O(N^2)，空间复杂度是O(N)
    public List<List<Integer>> solution1(int[] nums) {
        if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;  // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;   // 去重
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;     // 去重
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;    // 去重
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

}
