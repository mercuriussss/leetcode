package com.cjl.old.sword;

/*
    问题描述：
      地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
      一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
      例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
      请问该机器人能够到达多少个格子？
    示例 1：
      输入：m = 2, n = 3, k = 1
      输出：3
    示例 2：
      输入：m = 3, n = 1, k = 0
      输出：1
 */

public class Sword_13 {
    int x, y, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.x = m;
        this.y = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int x, int y, int sumX, int sumY) {
        if (x >= this.x || y >= this.y || sumX + sumY > this.k || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, (x + 1) % 10 == 0 ? sumX - 8 : sumX + 1, sumY)
                + dfs(x, y + 1, sumX, (y + 1) % 10 == 0 ? sumY - 8 : sumY + 1);
    }
}
