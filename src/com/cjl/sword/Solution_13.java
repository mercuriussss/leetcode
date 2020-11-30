package com.cjl.sword;

public class Solution_13 {
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
