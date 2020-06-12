package leetcode;

public class LC529 {

    private final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        if (board[i][j] == 'B' || (board[i][j] >= '1' && board[i][j] <= '8')) return;

        int count = 0;
        for (int k = 0; k < 8; k++) {
            int newX = i + DIR[k][0];
            int newY = j + DIR[k][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[i][j] = (char) ('0' + count);
            return;
        }
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int newX = i + DIR[k][0];
            int newY = j + DIR[k][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                dfs(board, newX, newY);
            }
        }

    }
}
