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

    public static void main(String[] args) {
        LC518 algo = new LC518();
        int res = algo.change(5, new int[]{1, 2, 5});
    }
}
