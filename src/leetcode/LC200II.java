package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC200II {
    int count;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return count;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] matrix, int i, int j) {
        Deque<Integer> qX = new LinkedList<>();
        Deque<Integer> qY = new LinkedList<>();
        qX.addLast(i);
        qY.addLast(j);
        matrix[i][j] = '.';
        while (!qX.isEmpty()) {
            int x = qX.removeFirst();
            int y = qY.removeFirst();
            if (x - 1 >= 0 && matrix[x - 1][y] == '1') {
                matrix[x - 1][y] = '.';
                qX.addLast(x - 1);
                qY.addLast(y);
            }
            if (y - 1 >= 0 && matrix[x][y - 1] == '1') {
                matrix[x][y - 1] = '.';
                qX.addLast(x);
                qY.addLast(y - 1);
            }
            if (x + 1 < matrix.length && matrix[x + 1][y] == '1') {
                matrix[x + 1][y] = '.';
                qX.addLast(x + 1);
                qY.addLast(y);
            }
            if (y + 1 < matrix[x].length && matrix[x][y + 1] == '1') {
                matrix[x][y + 1] = '.';
                qX.addLast(x);
                qY.addLast(y + 1);
            }
        }
    }
}
