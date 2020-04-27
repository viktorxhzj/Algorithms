import java.util.LinkedList;
import java.util.Queue;

public class LC542 {
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