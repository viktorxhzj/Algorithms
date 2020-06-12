package leetcode;

import java.util.ArrayList;

public class LC37 {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][] block = new boolean[9][9];
    public void solveSudoku(char[][] board) {


        /* 需要填数独的空格集合 */
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                    continue;
                }
                /* 注册已经填的数字 */
                int num = board[i][j] - '1';
                row[i][num] = true;
                col[j][num] = true;
                block[i / 3 * 3 + j / 3][num] = true;
            }
        }
        recur(list, 0, board);
    }

    private boolean recur(ArrayList<int[]> list, int depth, char[][] board) {
        if (depth == list.size()) {
            return true;
        }
        int i = list.get(depth)[0];
        int j = list.get(depth)[1];
        for (int k = 0; k < 9; k++) {
            /* 如果已经注册，跳过 */
            if (row[i][k] || col[j][k] || block[i / 3 * 3 + j / 3][k]) continue;

            /* 注册数字 */
            board[i][j] = (char) ('1' + k);
            row[i][k] = true;
            col[j][k] = true;
            block[i / 3 * 3 + j / 3][k] = true;

            /* DFS，如果DFS结果成功，直接返回 */
            if (recur(list, depth + 1, board)) return true;

            /* 如果DFS结果失败，状态重置，尝试下一个数字 */
            else {
                // board[i][j] = '.';
                row[i][k] = false;
                col[j][k] = false;
                block[i / 3 * 3 + j / 3][k] = false;
            }
        }

        /* 都不成功，返回 */
        return false;
    }
}
