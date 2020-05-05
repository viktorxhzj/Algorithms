package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// DFS
public class LC200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') dfs(grid, i, j);
                for (char[] cell: grid) {
                    for (char c: cell) System.out.print(c);
                    System.out.println();
                }
                count++;
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return ;
        grid[i][j] = '/';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

// BFS
class LC200B {
    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '/';
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int x = temp[0], y = temp[1];
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '/';
                            q.offer(new int[]{x + 1, y});
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '/';
                            q.offer(new int[]{x - 1, y});
                        }
                        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '/';
                            q.offer(new int[]{x, y + 1});
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '/';
                            q.offer(new int[]{x, y - 1});
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}