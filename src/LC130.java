import java.util.Arrays;
import java.util.LinkedList;

public class LC130 {
    public void solveDFS(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }

    public void solveBFS(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{i, j});
        board[i][j] = '#';

        while (!queue.isEmpty()) {
            int[] coord = queue.pollFirst();
            int x = coord[0], y = coord[1];

            if ((x - 1 >= 0) && board[x - 1][y] == 'O') {
                board[x - 1][y] = '#';
                queue.offerLast(new int[]{x - 1, y});
            }
            if ((y - 1 >= 0) && board[x][y - 1] == 'O') {
                board[x][y - 1] = '#';
                queue.offerLast(new int[]{x, y - 1});
            }
            if ((x + 1 < board.length) && board[x + 1][y] == 'O') {
                board[x + 1][y] = '#';
                queue.offerLast(new int[]{x + 1, y});
            }
            if ((y + 1 < board[x].length) && board[x][y + 1] == 'O') {
                board[x][y + 1] = '#';
                queue.offerLast(new int[]{x, y + 1});
            }
        }
    }

    public static void main(String[] args) {
        LC130 test = new LC130();
        char[][] m = new char[3][3];
        for (char[] row: m) Arrays.fill(row, 'O');
        test.solveBFS(m);
    }
}
