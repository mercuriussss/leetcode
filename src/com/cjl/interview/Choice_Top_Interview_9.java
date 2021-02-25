package com.cjl.interview;

/*
    问题描述：
        给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    示例 1：
        输入：x = 121
        输出：true
    示例 2：
        输入：x = -121
        输出：false
        解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    示例 3：
        输入：x = 10
        输出：false
        解释：从右向左读, 为 01 。因此它不是一个回文数。
    示例 4：
        输入：x = -101
        输出：false
    提示：
        -2^31 <= x <= 2^31 - 1
 */
public class Choice_Top_Interview_9 {

    // 暴力破解
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public boolean solution1(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // 数学算法破解
    public boolean solution2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        // 当输入为 12321 时, x = 12, revertedNum = 123
        return x == revertedNum || x == revertedNum / 10;
    }
}
