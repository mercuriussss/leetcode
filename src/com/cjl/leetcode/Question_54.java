package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    54. 螺旋矩阵
    问题描述：
        给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    示例 1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
    示例 2：
        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
    提示：
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100
 */
public class Question_54 {


    // 动态规划法
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public List<Integer> solution1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int t = 0;
        int b = matrix.length - 1;
        int l= 0;
        int r = matrix[0].length - 1;
        while(true) {
            //向右
            for(int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            if(++t > b) {
                break;
            }

            //向下
            for(int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if(--r < l) {
                break;
            }

            //向左
            for(int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            if(--b < t) {
                break;
            }

            //向上
            for(int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }
}
