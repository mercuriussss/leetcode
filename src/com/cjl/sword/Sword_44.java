package com.cjl.sword;

/*
    问题描述：
        数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
    请写一个函数，求任意第n位对应的数字。
        示例 1：
        输入：n = 3
        输出：3
    示例 2：
        输入：n = 11
        输出：0
    限制：
        0 <= n <2^31
 */
public class Sword_44 {

    // 时间复杂度O(logN)，空间复杂度O(logN)
    public int solution1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 确认n所在数字的位数
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 确定n所在的数字
        long num = start + (n - 1) / digit;
        // 确定n是所在数字的哪一位数
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}