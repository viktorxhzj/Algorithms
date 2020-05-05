package leetcode;

public class LC32 {
    public int longestValidParentheses(String s) {

        if (s.length() <= 1) return 0;

        int maxL = 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        for (int k = 1; k < s.length(); k++) {
            if (str[k] == '(') continue;
            if (str[k - 1] == '(') {
                dp[k] += 2;
                if (k - 2 > 0) dp[k] += dp[k - 2];
            }
            else if (k - dp[k - 1] - 1 >= 0 && str[k - dp[k - 1] - 1] == '(') {
                dp[k] += dp[k - 1] + 2;
                if (k - dp[k - 1] - 2 > 0) dp[k] += dp[k - dp[k - 1] - 2];
            }
            maxL = Math.max(maxL, dp[k]);
        }
        return maxL;
    }
}
