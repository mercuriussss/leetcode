package com.cjl.sword;

/*
    问题描述：
        在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    示例 1:
        输入: [7,5,6,4]
        输出: 5
    限制：
        0 <= 数组长度 <= 50000
 */

public class Solution_51 {

    // 归并排序法
    // 时间复杂度O(NlogN)，空间复杂度O(N)
    public int solution1(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    public int merge(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;//递归结束条件
        }
        int arrMid = start + ((end - start) >> 1);//左右数组分裂的中间界点位置
        //左右分别进行递归并统计逆序对数
        int count = merge(arr, start, arrMid) + merge(arr, arrMid + 1, end);

        int[] tempArr = new int[end - start + 1];//新建一个该层次的临时数组用于左右数组排序后的合并
        int i = start;//左边数组的移动指针
        int j = arrMid + 1;//右边数组的移动指针
        int k = 0;//临时数组tempArr的移动指针

        while (i <= arrMid && j <= end) {//左右两数组都还剩有数字未排序时
            if (arr[i] > arr[j]) {   //如果左边大于右边,构成逆序对
                /*核心代码*/
                //左数组i位置及其后的数值均比右数值j位置大，故累加上i位置及其后的数值的长度
                count += arrMid - i + 1;
                /*核心代码*/
                tempArr[k++] = arr[j++]; //右数组移动到tempArr中
            } else {              //如果左小于等于右，不构成逆序对
                tempArr[k++] = arr[i++]; //左数组移动到tempArr中
            }
        }
        //左右两数组有一边已经移动完毕，剩下另一边可进行快速移动
        while (i <= arrMid) {  //右边数组已全部被对比过且移动完成，将剩下的左边数组快速移入tempArr中
            tempArr[k++] = arr[i++];
        }
        while (j <= end) {  //左边数组已全部被对比过且移动完成，将剩下的右边数组快速移入tempArr中
            tempArr[k++] = arr[j++];
        }
        //将tempArr中的数还原回原arr中，需加上start确保在原arr上位置正确
        for (int a = 0; a < tempArr.length; a++) {
            arr[a + start] = tempArr[a];
        }
        return count;
    }
}