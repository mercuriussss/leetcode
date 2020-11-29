package com.cjl.sword;

public class Solution_16 {
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
}
