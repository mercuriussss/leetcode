package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
    46. 全排列
    问题描述：
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    示例 1：
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    示例 2：
        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
    示例 3：
        输入：nums = [1]
        输出：[[1]]
    提示：
        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
        nums 中的所有整数 互不相同
 */
public class Question_46 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        recur(nums, new ArrayList<>(), res);
        return res;
    }

    private void recur(int[] nums, List<Integer> target, List<List<Integer>> res) {
        if (target.size() == nums.length) {
            res.add(new ArrayList<>(target));
            return;
        }
        for (int cur : nums) {
            if (target.contains(cur)) {
                continue;
            }
            target.add(cur);
            recur(nums, target, res);
            target.remove(target.size() - 1);
        }
    }
}
