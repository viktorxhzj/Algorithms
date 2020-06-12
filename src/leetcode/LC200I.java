package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// DFS
public class LC200I {
    int count;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return count;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] matrix, int i, int j) {
        /*
        递归终止条件
        1. 超出边界
        2. 当前元素为水
        3. 当前元素为已遍历过的陆地
         */
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] != '1') return;
        /* 根据更改属性值来达到visited的效果 */
        matrix[i][j] = '.';
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);

    }
}