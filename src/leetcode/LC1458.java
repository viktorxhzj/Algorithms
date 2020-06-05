package leetcode;

public class LC1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // dp[i][j] 代表1...i, 1...j 为止的最大点积
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = Integer.MIN_VALUE;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = Integer.MIN_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int local = Integer.MIN_VALUE;

                // 不选nums1[i]
                local = Math.max(local, dp[i][j + 1]);

                // 不选nums2[j]
                local = Math.max(local, dp[i + 1][j]);

                // nums1[i]和nums2[j]都选
                local = Math.max(local, Math.max(0, dp[i][j]) + nums1[i] * nums2[j]);

                dp[i + 1][j + 1] = local;
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
