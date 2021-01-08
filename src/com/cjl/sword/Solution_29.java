package com.cjl.sword;

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

    // 时间复杂度O(MN)，空间复杂度O(1)
    public int[] solution1(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int num = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while(true){

            //left to right
            for (int i = left; i <= right; i++) {
                res[num++] = matrix[top][i];
            }
            if(++top > bottom){
                break;
            }

            //top to bottom
            for (int i = top; i <= bottom ; i++) {
                res[num++] = matrix[i][right];
            }
            if(left > --right){
                break;
            }

            //right to left
            for (int i = right; i >= left; i--) {
                res[num++] = matrix[bottom][i];
            }
            if(top > --bottom){
                break;
            }

            //bottom to top
            for (int i = bottom; i >= top; i--) {
                res[num++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
