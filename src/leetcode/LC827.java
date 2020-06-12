package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC827 {
    private final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {

        /* 并查集 */
        int[] parent = new int[grid.length * grid[0].length];
        int[] sizes = new int[grid.length * grid[0].length];
        Arrays.fill(sizes, 1);

        /* 初始化并查集，所有的父节点皆为自身 */
        for (int k = 0; k < parent.length; k++) {
            parent[k] = k;
        }

        /* 进行DFS并更新并查集与每个集的大小 */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) dfs(grid, parent, sizes, i, j);
            }
        }

        int maxArea = 0;
        for (int size: sizes) maxArea = Math.max(size, maxArea);

        /* 如果有海洋，并且海洋的附近有陆地，将海洋连接的陆地合并 */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int updatedSize = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] ints : DIR) {
                        int newX = i + ints[0];
                        int newY = j + ints[1];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[i].length && grid[newX][newY] == -1 && !set.contains(parent[newX * grid[i].length + newY])) {
                            set.add(parent[newX * grid[i].length + newY]);
                            updatedSize += sizes[parent[newX * grid[i].length + newY]];
                        }
                    }
                    maxArea = Math.max(maxArea, updatedSize);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int[] parent, int[] size, int i, int j) {
        grid[i][j] = -1;
        for (int[] ints : DIR) {
            int newX = i + ints[0];
            int newY = j + ints[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[i].length && grid[newX][newY] == 1) {
                parent[newX * grid[i].length + newY] = parent[i * grid[i].length + j];
                size[parent[i * grid[i].length + j]]++;
                dfs(grid, parent, size, newX, newY);
            }
        }

    }

}
