package com.cjl.interview;

/*
    问题描述：
        给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
        返回被除数 dividend 除以除数 divisor 得到的商。
        整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    示例 1:
        输入: dividend = 10, divisor = 3
        输出: 3
        解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
    示例 2:
        输入: dividend = 7, divisor = -3
        输出: -2
        解释: 7/-3 = truncate(-2.33333..) = -2
    提示：
        被除数和除数均为 32 位有符号整数。
        除数不为 0。
        假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
        本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class Choice_Top_Interview_29 {

    // 时间复杂度是O(1),空间复杂度是O(1)
    public int solution1(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend ^ divisor) >= 0;
        long t = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int res = 0;
        for (int i = 32; i >= 0 ; i--) {
            if((t >> i) >= d){
                res += 1 << i;
                t -= d << i;
            }
        }
        return sign? res : -res;
    }
}
