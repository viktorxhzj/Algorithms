package leetcode;

import java.util.*;

public class LC52 {
    private boolean[] rows;
    private boolean[] cols;
    private boolean[] diagonals1;
    private boolean[] diagonals2;

    /* 默认空棋盘的一行 */
    private char[] ori;

    /* 通过toString避免重复的集合 */
    private Set<String> set = new HashSet<>();

    private int ans;

    public int totalNQueens(int n) {

        rows = new boolean[n];
        cols = new boolean[n];
        diagonals1 = new boolean[2 * n + 1];
        diagonals2 = new boolean[2 * n + 1];
        ori = new char[n];
        Arrays.fill(ori, '.');

        recur(n, 0, new StringBuilder());

        return ans;
    }

    private void recur(int n, int x, StringBuilder bd) {
        /* 达到棋盘的最后一行，添加进答案 */
        if (x == n) {
            /* 避免重复 */
            if (set.contains(bd.toString())) return;
            ans++;
            return;
        }

        /* 在当前行探索不同列的可能性 */
        for (int y = 0; y < n; y++) {
            if (rows[x] || cols[y] || diagonals1[x + y] || diagonals2[x - y + n]) continue;

            ori[y] = 'Q';
            bd.append(ori);
            ori[y] = '.';

            rows[x] = true;
            cols[y] = true;
            diagonals1[x + y] = true;
            diagonals2[x - y + n] = true;

            recur(n, x + 1, bd);

            /* 状态重置 */
            bd.delete(bd.length() - n, bd.length());
            rows[x] = false;
            cols[y] = false;
            diagonals1[x + y] = false;
            diagonals2[x - y + n] = false;
        }
    }
}
