package com.cjl.leetcode;

/*
    7. 整数反转
    问题描述：
        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
        如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
        假设环境不允许存储 64 位整数（有符号或无符号）。
    示例 1：
        输入：x = 123
        输出：321
    示例 2：
        输入：x = -123
        输出：-321
    示例 3：
        输入：x = 120
        输出：21
    示例 4：
        输入：x = 0
        输出：0
    提示：
        -2^31 <= x <= 2^31 - 1
 */
public class Question_7 {

    // 时间复杂度是O(1)，空间复杂度是O(1)
    public static int solution1(int x){
        boolean flag = x > 0;
        if(!flag && Math.abs(x) >= Integer.MAX_VALUE) {
            return 0;
        }
        int res = 0;
        int temp = Math.abs(x);
        while(temp != 0) {
            if(res > (Integer.MAX_VALUE - temp % 10)/10){
                return 0;
            }else{
                res = res * 10 + temp % 10;
                temp /= 10;
            }
        }
        return flag ? res: -res;
    }

    public static int solution2(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int res = 0;
        int temp = Math.abs(x);
        while (temp != 0) {
            int num = temp % 10;
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return 0;
            } else {
                res = res * 10 + num;
                temp = temp / 10;
            }
        }
        return (x > 0)? res : -res;
    }
}
