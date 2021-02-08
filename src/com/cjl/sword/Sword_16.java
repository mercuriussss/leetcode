package com.cjl.sword;

/*
    问题描述：
      实现函数double Power(double base, int exponent)，求base的exponent次方。
      不得使用库函数，同时不需要考虑大数问题。
    示例 1:
      输入: 2.10000, 3
      输出: 9.26100
    示例 2:
      输入: 2.00000, -2
      输出: 0.25000
 */

public class Sword_16 {
    public double myPow(double x, int n) {
        return solution1(x,n);
    }
    public double solution1(double x, int n){
        if (n == 0) {
            return 1;
        }
        //如果n小于0，把它改为正数，并且把1/x提取出来一个
        if (n < 0) {
            return 1 / x * myPow(1 / x, -n - 1);
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public double solution2(double x, int n){
        double result = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if (i % 2 != 0) {
                //i是奇数
                result *= x;
            }
        }
        return n < 0 ? 1.0 / result : result;
    }

    public double solution3(double x, int n) {
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        long b = n;
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        while(b > 0){
            if((b&1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
