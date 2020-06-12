package leetcode;

public class LC44 {
    public boolean isMatch(String s, String p) {

        char[] sstr = s.toCharArray();
        char[] pstr = p.toCharArray();

        boolean[][] dp = new boolean[sstr.length + 1][pstr.length + 1];
        dp[0][0] = true;
        for (int j = 0; j < pstr.length; j++) {
            dp[0][j + 1] = pstr[j] == '*' && dp[0][j];
        }

        for (int i = 0; i < sstr.length; i++) {
            for (int j = 0; j < pstr.length; j++) {
                switch (pstr[j]) {
                    case '*':
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j] || dp[i][j + 1];
                        break;
                    case '?':
                        dp[i + 1][j + 1] = dp[i][j];
                        break;
                    default:
                        dp[i + 1][j + 1] = pstr[j] == sstr[i] && dp[i][j];
                        break;
                }
            }
        }

        return dp[sstr.length][pstr.length];
    }
}
