package leetcode;

public class LC518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}

class LC518II {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) dp[i][0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j >= coins[i])  dp[i + 1][j] += dp[i + 1][j - coins[i]];
            }
        }
        return dp[coins.length][amount];
    }

}
