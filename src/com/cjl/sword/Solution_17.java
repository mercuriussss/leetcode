package com.cjl.sword;

/*
    问题描述：
      输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
      比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    示例 1:
      输入: n = 1
      输出: [1,2,3,4,5,6,7,8,9]
 */

public class Solution_17 {

    public int[] printNumbers(int n) {
        solution2(n);
        return null;
    }

    // 不考虑大数的简单循环
    public int[] solution1(int n) {
        int nums = (int) Math.pow(10, n) - 1;
        int[] res = new int[nums];
        for (int i = 0; i < nums; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    // 考虑到大数的解法，大数只能用字符串表示
    StringBuffer res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String solution2(int n) {
        this.n = n;
        res = new StringBuffer();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                res.append(s).append(",");
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }
        for (char i : loop) {
            if (i == '9') {
                nine++;
            }
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }


    // solution2的简化版
    char[] num2, loop2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder res2 = new StringBuilder();
    public String solution3(int len) {
        num2 = new char[len];
        for (int i = 1; i <= len; i++) {
            dfs(0, i);
        }
        return res2.deleteCharAt(res2.length() - 1).toString();
    }

    public void dfs(int index, int len) {
        if (index == len) {
            res2.append(new String(num2)).append(",");
            return;
        }
        int start = 0;
        if (index == 0) {
            start = 1;
        }
        for (int i = start; i < 10; i++) {
            num2[index] = loop2[i];
            dfs(index + 1, len);
        }
    }
}
