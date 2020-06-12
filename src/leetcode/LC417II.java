package leetcode;

import java.util.*;

public class LC417II {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return ans;

        boolean[][] canReachP = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachA = new boolean[matrix.length][matrix[0].length];

        for (int i = 0, j = 0; i < matrix.length; i++) {
            bfs(matrix, canReachA, i, j);
        }
        for (int i = 0, j = 0; j < matrix[i].length; j++) {
            bfs(matrix, canReachA, i, j);
        }
        for (int i = 0, j = matrix[i].length - 1; i < matrix.length; i++) {
            bfs(matrix, canReachP, i, j);
        }

        for (int i = matrix.length - 1, j = 0; j < matrix[i].length; j++) {
            bfs(matrix, canReachP, i, j);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (canReachA[i][j] && canReachP[i][j]) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;

    }

    private void bfs(int[][] matrix, boolean[][] visited, int i, int j) {
        Deque<Integer> qX = new LinkedList<>();
        Deque<Integer> qY = new LinkedList<>();
        qX.addLast(i);
        qY.addLast(j);
        visited[i][j] = true;
        while (!qX.isEmpty()) {
            int x = qX.removeFirst();
            int y = qY.removeFirst();
            if (x - 1 >= 0 && matrix[x - 1][y] >= matrix[x][y] && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                qX.addLast(x - 1);
                qY.addLast(y);
            }
            if (y - 1 >= 0 && matrix[x][y - 1] >= matrix[x][y] && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                qX.addLast(x);
                qY.addLast(y - 1);
            }
            if (x + 1 < matrix.length && matrix[x + 1][y] >= matrix[x][y] && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                qX.addLast(x + 1);
                qY.addLast(y);
            }
            if (y + 1 < matrix[x].length && matrix[x][y + 1] >= matrix[x][y] && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                qX.addLast(x);
                qY.addLast(y + 1);
            }
        }
    }
}
