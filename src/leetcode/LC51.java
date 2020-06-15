package leetcode;

import java.util.*;

public class LC51 {
    private boolean[] rows;
    private boolean[] cols;
    private boolean[] diagonals1;
    private boolean[] diagonals2;

    /* 默认空棋盘的一行 */
    private char[] ori;

    /* 答案集合 */
    private List<List<String>> ans = new ArrayList<>();

    /* 通过toString避免重复的集合 */
    private Set<String> set = new HashSet<>();

    /* 一个棋盘 */
    private List<String> solution;

    public List<List<String>> solveNQueens(int n) {

        rows = new boolean[n];
        cols = new boolean[n];
        diagonals1 = new boolean[2 * n + 1];
        diagonals2 = new boolean[2 * n + 1];
        ori = new char[n];
        Arrays.fill(ori, '.');

        solution = new ArrayList<>(n);
        for (int i = 0; i < n; i++) solution.add("");


        recur(n, 0, new LinkedList<>());

        return ans;
    }

    private void recur(int n, int x, Deque<int[]> stack) {
        /* 达到棋盘的最后一行，添加进答案 */
        if (x == n) {
            for (int[] pair : stack) {
                ori[pair[1]] = 'Q';
                solution.set(pair[0], new String(ori));
                ori[pair[1]] = '.';
            }
            /* 避免重复 */
            if (set.contains(solution.toString())) return;
            ans.add(new ArrayList<>(solution));
            set.add(solution.toString());
            return;
        }

        /* 在当前行探索不同列的可能性 */
        for (int y = 0; y < n; y++) {
            if (rows[x] || cols[y] || diagonals1[x + y] || diagonals2[x - y + n]) continue;

            stack.addLast(new int[]{x, y});
            rows[x] = true;
            cols[y] = true;
            diagonals1[x + y] = true;
            diagonals2[x - y + n] = true;

            recur(n, x + 1, stack);

            /* 状态重置 */
            stack.removeLast();
            rows[x] = false;
            cols[y] = false;
            diagonals1[x + y] = false;
            diagonals2[x - y + n] = false;
        }
    }

}
