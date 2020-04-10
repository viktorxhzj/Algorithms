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