package com.cjl.leetcode;

import java.util.*;

/*
    56. 合并区间
    问题描述：
        以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
    示例 1：
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例2：
        输入：intervals = [[1,4],[4,5]]
        输出：[[1,5]]
        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
    提示：
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4
 */
public class Question_56 {

    public int[][] solution1(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        List<Integer> arr = new ArrayList<>();
        // 按最小界排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 记录前面的最大界
        int preEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > preEnd) {
                // 当前最小界大于前面的最大界，不能合并
                arr.add(interval[0]);
                arr.add(interval[1]);
            } else if (interval[1] > preEnd) {
                // 当前最小界小于或等于前面的最大界，并且当前最大界大于前面的最大界，可合并
                arr.remove(arr.size() - 1);
                arr.add(interval[1]);
            }
            preEnd = Math.max(preEnd, interval[1]);
        }
        int[][] res = new int[arr.size() / 2][2];
        for (int i = 0; i < arr.size(); i++) {
            res[i / 2][i % 2] = arr.get(i);
        }
        return res;
    }
}
