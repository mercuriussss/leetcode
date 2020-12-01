package com.cjl.sword;

/*
    问题描述：
      请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
      例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。示
    示例 1：
      输入：00000000000000000000000010000000
      输出：1
      解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 */

public class Solution_15 {
    public int hammingWeight(int n){
        return solution1(n);
    }


    // 利用n&(n−1)，每次把最右位的1变为0，只需循环二进制的数字为1的位数即可
    // 时间复杂度为O(M)，空间复杂度为O(1)
    public int solution1(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    // 逐位循环判断，若 n&1=0，则最右位是0，若为1则是1
    // 时间复杂度为O(log2n)，空间复杂度为O(1)
    public int solution2(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
