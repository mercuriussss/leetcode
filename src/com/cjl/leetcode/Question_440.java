package com.cjl.leetcode;

/*
    440. 字典序的第K小数字
    问题描述：
        给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
    注意：
        1 ≤ k ≤ n ≤ 10^9。
    示例：
        输入:n: 13   k: 2
        输出:10
        解释:字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */
public class Question_440 {

    // 时间复杂度是O(k)，空间复杂度是O(1)
    public int solution1(int n, int k) {
        int cur = 1;
        k = k - 1;
        while(k > 0) {
            int num = getCount(n, cur, cur + 1);
            if(num <= k) {
                // 若第k个数不在以cur为根节点的树上，则往右移动到兄弟节点
                cur += 1;
                k -= num;
            }else{
                // 第k个数在以cur为根节点的树上，往子节点移动
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }

    private int getCount(int n, int first, int last){
        int num = 0;
        while(first <= n) {
            // 比如n是195的情况195到100有96个数
            num += Math.min(n+1, last) - first;
            // 防止溢出
            if(first <= n / 10){
                first *= 10;
                last *= 10;
            } else {
                break;
            }
        }
        return num;
    }
}
