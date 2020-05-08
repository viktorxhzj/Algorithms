package leetcode;

public class LC983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int j = 0;
        for (int i = 1; i <= 365; i++) {
            if (j == days.length) break;
            if (days[j] != i) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = i - 7 >= 0? Math.min(dp[i - 7] + costs[1], dp[i]): Math.min(costs[1], dp[i]);
            dp[i] = i - 30 >= 0? Math.min(dp[i - 30] + costs[2], dp[i]): Math.min(costs[2], dp[i]);
            j++;
        }
        return dp[days[j - 1]];

    }
}
