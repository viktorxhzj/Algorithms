package leetcode;

public class LC91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        char[] str = s.toCharArray();

        int[] dp = new int[str.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == '0') {
                if (str[i - 1] == '1' || str[i - 1] == '2') dp[i + 1] = dp[i - 1];
                else return 0;
            }
            else {
                dp[i + 1] = dp[i];
                if ((str[i - 1] == '2' && str[i] - '0' <= 6) || str[i - 1] == '1') dp[i + 1] += dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
