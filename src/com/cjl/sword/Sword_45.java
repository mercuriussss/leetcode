package com.cjl.sword;

import java.util.Arrays;

/*
    问题描述：
        输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    示例 1:
        输入: [10,2]
        输出: "102"
    示例2:
        输入: [3,30,34,5,9]
        输出: "3033459"
    提示:
        0 < nums.length <= 100
    说明:
        输出结果可能非常大，所以你需要返回一个字符串而不是整数
        拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Sword_45 {

    // 内置函数法
    // 时间复杂度O(NlogN)，空间复杂度O(N)
    public String solution1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    // 快速排序法
    // 时间复杂度O(NlogN)，空间复杂度O(N)
    public String solution2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        System.currentTimeMillis();
        return res.toString();
    }

    private void fastSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (i < j) {
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) i++;
            swap(strs, i, j);
        }
        swap(strs, i, left);
        fastSort(strs, left, i - 1);
        fastSort(strs, i + 1, right);
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
