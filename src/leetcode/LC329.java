package leetcode;

public class LC329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] record = new int[matrix.length][matrix[0].length];

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (record[i][j] != 0) {
                    ans = Math.max(ans, record[i][j]);
                }
                else {
                    ans = Math.max(ans, dfs(record, matrix, i, j));
                }
            }
        }
        return ans;

    }


    private int dfs(int[][] record, int[][] matrix, int i, int j) {
        int nextLen = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            if (record[i - 1][j] == 0) {
                nextLen = Math.max(nextLen, dfs(record, matrix, i - 1, j));
            }
            else {
                nextLen = Math.max(nextLen, record[i - 1][j]);
            }

        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            if (record[i][j - 1] == 0) {
                nextLen = Math.max(nextLen, dfs(record, matrix, i, j - 1));
            }
            else {
                nextLen = Math.max(nextLen, record[i][j - 1]);
            }
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            if (record[i + 1][j] == 0) {
                nextLen = Math.max(nextLen, dfs(record, matrix, i + 1, j));
            }
            else {
                nextLen = Math.max(nextLen, record[i + 1][j]);
            }
        }
        if (j + 1 < matrix[i].length && matrix[i][j + 1] > matrix[i][j]) {
            if (record[i][j + 1] == 0) {
                nextLen = Math.max(nextLen, dfs(record, matrix, i, j + 1));
            }
            else {
                nextLen = Math.max(nextLen, record[i][j + 1]);
            }
        }
        record[i][j] = 1 + nextLen;
        return 1 + nextLen;
    }
}
