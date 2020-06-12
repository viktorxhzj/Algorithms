package leetcode;

public class LC10 {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();

        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];

        dp[0][0] = true;
        for (int j = 1; j < ptr.length; j++) {
            /* 带有*直接压缩 */
            if (ptr[j] == '*') dp[0][j + 1] = dp[0][j - 1];
        }

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < ptr.length; j++) {
                switch (ptr[j]) {
                    case '.':
                        dp[i + 1][j + 1] = dp[i][j];
                        break;
                    case '*':
                        boolean res = false;

                        if (j - 1 >= 0) {
                            /* 匹配0个前面的元素 */
                            res = dp[i + 1][j - 1];

                            /* 匹配1-n个前面的元素（前面的元素为任意元素） */
                            if (ptr[j - 1] == '.') {
                                res = res || dp[i][j + 1];
                            }
                            /* 匹配1-n个前面的元素（前面元素不是任意元素，需要判断） */
                            else {
                                res = res || (str[i] == ptr[j - 1] && dp[i][j + 1]);
                            }
                        }
                        dp[i + 1][j + 1] = res;
                        break;
                    default:
                        dp[i + 1][j + 1] = str[i] == ptr[j] && dp[i][j];
                        break;
                }
            }
        }
        return dp[str.length][ptr.length];
    }
}
