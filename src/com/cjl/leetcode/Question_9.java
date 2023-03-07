package com.cjl.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    9. 回文数
    问题描述：
        给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        例如，121 是回文，而 123 不是。
    示例 1：
        输入：x = 121
        输出：true
    示例2：
        输入：x = -121
        输出：false
        解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3：
        输入：x = 10
        输出：false
        解释：从右向左读, 为 01 。因此它不是一个回文数。
    提示：
        -2^31<= x <= 2^31- 1
        进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Question_9 {

    // 时间复杂度是O(1)，空间复杂度是O(1)
    public boolean solution1(int x){
        if (x < 0) {
            return false;
        }
        int original = x;
        int revert = 0;
        while (original != 0) {
            if (revert > (Integer.MAX_VALUE - original % 10)/10) {
                return false;
            }
            revert = revert * 10 + original % 10;
            original = original / 10;
        }
        return revert == x;
    }
}
