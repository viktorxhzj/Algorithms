import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1。
 *
 * 思路：多源BFS
 */
class LC542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    matrix[i][j] = -1;
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] temp = queue.poll();
                if (temp[0] + 1 < matrix.length && matrix[temp[0] + 1][temp[1]] != -1) {
                    res[temp[0] + 1][temp[1]] = level;
                    matrix[temp[0] + 1][temp[1]] = -1;
                    queue.offer(new int[]{temp[0] + 1, temp[1]});
                }
                if (temp[0] - 1 >= 0 && matrix[temp[0] - 1][temp[1]] != -1) {
                    res[temp[0] - 1][temp[1]] = level;
                    matrix[temp[0] - 1][temp[1]] = -1;
                    queue.offer(new int[]{temp[0] - 1, temp[1]});
                }
                if (temp[1] + 1 < matrix[0].length && matrix[temp[0]][temp[1] + 1] != -1) {
                    res[temp[0]][temp[1] + 1] = level;
                    matrix[temp[0]][temp[1] + 1] = -1;
                    queue.offer(new int[]{temp[0], temp[1] + 1});
                }
                if (temp[1] - 1 >= 0 && matrix[temp[0]][temp[1] - 1] != -1) {
                    res[temp[0]][temp[1] - 1] = level;
                    matrix[temp[0]][temp[1] - 1] = -1;
                    queue.offer(new int[]{temp[0], temp[1] - 1});
                }
            }
            level++;
        }
        return res;
    }
}

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 思路：DFS/BFS
 *
 */
class LC200 {
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

    public int numIslands2(char[][] grid) {
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