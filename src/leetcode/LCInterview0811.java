package leetcode;

public class LCInterview0811 {
    public int waysToChange(int n) {
        int[][] dp = new int[4][n + 1];
        for (int j = 0; j < n + 1; j++) dp[0][j] = 1;
        for (int j = 0; j < n + 1; j++) {
            if (j < 5) dp[1][j] = dp[0][j];
            else dp[1][j] = (dp[0][j] + dp[1][j - 5]) % 1000000007;
        }
        for (int j = 0; j < n + 1; j++) {
            if (j < 10) dp[2][j] = dp[1][j];
            else dp[2][j] = (dp[1][j] + dp[2][j - 10]) % 1000000007;
        }
        for (int j = 0; j < n + 1; j++) {
            if (j < 25) dp[3][j] = dp[2][j];
            else dp[3][j] = (dp[2][j] + dp[3][j - 25]) % 1000000007;
        }
        return dp[3][n];
    }
}