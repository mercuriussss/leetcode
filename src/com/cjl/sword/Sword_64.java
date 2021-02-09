package com.cjl.sword;

/*
    问题描述：
        求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    示例 1：
        输入: n = 3
        输出: 6
    示例 2：
        输入: n = 9
        输出: 45
    限制：
        1 <= n <= 10000
 */
public class Sword_64 {

    // 利用逻辑运算符的短路效应
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public int solution1(int n) {
        return recur(n);
    }

    private int recur(int n) {
        // 此处的布尔型变量只作为辅助使用
        boolean b = (n > 1) && ((n += recur(n - 1)) > 0);
        return n;
    }
}
