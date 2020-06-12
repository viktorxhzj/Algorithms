package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class LC130 {
    public void solve(char[][] M) {
        if (M == null || M.length == 0) return;

        for (int i = 0, j = 0; i < M.length; i++) {
            if (M[i][j] == 'O') dfs(M, i, j);
        }
        for (int i = 0, j = M[i].length - 1; i < M.length; i++) {
            if (M[i][j] == 'O') dfs(M, i, j);
        }
        for (int i = 0, j = 0; j < M[i].length; j++) {
            if (M[i][j] == 'O') dfs(M, i, j);
        }
        for (int i = M.length - 1, j = 0; j < M[i].length; j++) {
            if (M[i][j] == 'O') dfs(M, i, j);
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = M[i][j] == '.'? 'O': 'X';
            }
        }
    }


    public void dfs(char[][] M, int i, int j) {
        if (i < 0 || j < 0 || i >= M.length || j >= M[i].length || M[i][j] != 'O') return;

        M[i][j] = '.';

        dfs(M, i + 1, j);
        dfs(M, i - 1, j);
        dfs(M, i, j + 1);
        dfs(M, i, j - 1);
    }
}
