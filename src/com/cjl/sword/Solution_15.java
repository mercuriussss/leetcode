package com.cjl.sword;

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
