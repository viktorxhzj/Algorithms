/**
 * 剑指42
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * DP[i] = max(DP[i - 1] + Ai, Ai)
 * solution = max(DP[1]...DP[n])
 */
class JZ42 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int local = 0;
        for (int num: nums) {
            if (local > 0) local += num;
            else local = num;
            if (local > res) res = local;
        }
        return res;
    }
}

/**
 * 剑指46
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 思路：一维动态规划表
 */
class JZ46 {
    public int translateNum(int num) {
        if (num == 0) return 0;
        char[] str = String.valueOf(num).toCharArray();
        int[] dp = new int[str.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int j = str[i - 1] - '0' + (str[i - 2] - '0') * 10;
            if (j >= 10 && j <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else dp[i] = dp[i - 1];
        }
        return dp[dp.length - 1];
    }
}

/**
 * 剑指47
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 思路：二维动态规划表
 */
class JZ47 {
    public int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) continue;
                if (i == row - 1) grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == col - 1) grid[i][j] = grid[i][j] + grid[i + 1][j];
                else grid[i][j] = grid[i][j + 1] > grid[i + 1][j] ? grid[i][j] + grid[i][j + 1]: grid[i][j] + grid[i + 1][j];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        JZ47 test = new JZ47();
        int res = test.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}

/**
 * 剑指48
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 思路：一维动态规划
 */
class JZ48 {
    public int lengthOfLongestSubstring(String s) {
        char[] strs = s.toCharArray();
        int[] dp = new int[strs.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < strs.length; i++) {
            int k = i;
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                if (strs[j] == strs[i]) k = j;
            }
            dp[i] = k == i ? dp[i - 1] + 1 : i - k;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}

/**
 * 剑指49
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
class JZ49 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

/**
 * 剑指63
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 思路：动态规划
 */
class JZ63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int res = 0;
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            dp = Math.max(0, dp + prices[i] - prices[i - 1]);
            res = Math.max(res, dp);
        }
        return res;
    }

    public int maxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

}

/**
 * LeetCode 10
 * 正则表达式匹配
 */
class LC10 {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i ++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.') dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}

/**
 * LeetCode 304
 */
class LC304 {
    int row = 0, col = 0;
    int[][] dp;
    public LC304(int[][] matrix) {
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
            int i, j;
            dp = new int[row][col];
            dp[0][0] = matrix[0][0];
            for (j = 1; j < col; j++) dp[0][j] = dp[0][j - 1] + matrix[0][j];
            for (i = 1; i < row; i++) dp[i][0] = dp[i - 1][0] + matrix[i][0];
            for (i = 1; i < row; i ++) {
                for (j = 1; j < col; j++) {
                    dp[i][j] = matrix[i][j] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row == 0 && col == 0) return 0;
        if (row1 - 1 < 0 && col1 - 1 < 0) return dp[row2][col2];
        if (row1 - 1 < 0) return dp[row2][col2] - dp[row2][col1 - 1];
        if (col1 - 1 < 0) return dp[row2][col2] - dp[row1 - 1][col2];
        return dp[row2][col2] + dp[row1 - 1][col1 - 1] - dp[row1 - 1][col2] - dp[row2][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */