package com.cjl.leetcode;

/*
    670. 最大交换
    问题描述：
        给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
    示例 1 :
        输入: 2736
        输出: 7236
        解释: 交换数字2和数字7。
    示例 2 :
        输入: 9973
        输出: 9973
        解释: 不需要交换。
    注意:
        给定数字的范围是 [0, 108]
 */
public class Question_670 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int left = 0;
        int right = 0;
        int maxIndex = chars.length - 1;

        // 从右往左遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIndex]) {
                // 让maxIndex保持为最大数的下标
                maxIndex = i;
            } else if (chars[i] < chars[maxIndex]) {
                // 如果遇到小于maxIndex的数字，则进行记录下标，等结束再交换
                left = i;
                right = maxIndex;
            }
        }

        // 交换
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        return Integer.parseInt(new String(chars));
    }
}
