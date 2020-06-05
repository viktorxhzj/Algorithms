package leetcode;

public class LC221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = matrix[i][j] == '0'? 0: 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res * res;
    }
}
