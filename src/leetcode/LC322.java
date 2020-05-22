package leetcode;

public class LC322 {
    public int coinChange(int[] coins, int amount) {

        // dp[k] 组成金额为k的最少硬币个数
        // dp[k] = min(dp[k - c1] + 1, dp[k - c2] + 1, ...)
        int max = amount + 1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = max;

        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount? -1: dp[amount];
    }
}
