package com.cjl.sword;

/*
    问题描述：
        在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    示例:
        现有矩阵 matrix 如下：
        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
        给定 target = 5，返回 true。
        给定 target = 20，返回 false。
    限制：
        0 <= n <= 1000
        0 <= m <= 1000
 */

public class Sword_4 {

    // 时间复杂度为O(M+N)，M和N为矩阵的行列数，空间复杂度为O（1）
    public boolean solution1(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length - 1;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){
                row --;
            }else if(matrix[row][col] < target){
                col ++;
            }else{
                return true;
            }
        }
        return false;
    }


    // 二分查找法，时间复杂度为是O(klg(h)) k=min(m,n) h=max(m,n)，空间复杂度为O(1)
    // (评论区的做法，不确定时间复杂度是否正确，实际上跑起来比方法1要费时间，似乎找不到时间复杂度为O(n)以下的解法)
    public boolean solution2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if(row > col){
            for (int i = 0; i < col; i++) {
                int[] tmp = new int[row];
                for (int j = 0; j < row; j++) {
                    tmp[j] = matrix[j][i];
                }
                if(binarySearch(target,tmp)){
                    return true;
                }
            }
        }else{
            for (int i = 0; i < row; i++) {
                if(binarySearch(target,matrix[i])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int target,int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(target == arr[mid]){
                return true;
            }else if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
