package com.cjl.sword;

import java.util.ArrayList;

/*
    问题描述：
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    示例 1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
    示例 2：
        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
    限制：
        0 <= matrix.length <= 100
        0 <= matrix[i].length <= 100
 */
public class Solution_29 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        Solution_29 test = new Solution_29();
        System.out.println(test.solution1(arr));
    }


    public int[] solution1(int[][] matrix) {
        int rows = matrix.length;
        int lines = matrix[0].length;
        int[] arr = new int[lines * rows];
        int row = 0;
        int line = 0;
        int num = 0;
        int times = 0;
        while (num != rows * lines) {
            while (line < lines - 1 - times) {
                arr[num++] = matrix[row][line++];
            }
            while (row < rows - 1 - times) {
                arr[num++] = matrix[row++][line];
            }
            while (line > times + 1) {
                arr[num++] = matrix[row][line--];
            }
            while (row > times + 1) {
                arr[num++] = matrix[row--][line];
            }
            times ++;
        }
        return arr;
    }
}
