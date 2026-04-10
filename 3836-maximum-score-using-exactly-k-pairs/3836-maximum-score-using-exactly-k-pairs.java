class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        long NEG = Long.MIN_VALUE / 4;

        long[][][] dp = new long[n + 1][m + 1][k + 1];

        // Initialize
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                for (int t = 0; t <= k; t++)
                    dp[i][j][t] = NEG;

        dp[0][0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int t = 0; t <= k; t++) {
                    if (i > 0)
                        dp[i][j][t] = Math.max(dp[i][j][t], dp[i - 1][j][t]);

                    if (j > 0)
                        dp[i][j][t] = Math.max(dp[i][j][t], dp[i][j - 1][t]);

                    if (i > 0 && j > 0 && t > 0 && dp[i - 1][j - 1][t - 1] != NEG) {
                        long val = dp[i - 1][j - 1][t - 1]
                                   + (long) nums1[i - 1] * nums2[j - 1];
                        dp[i][j][t] = Math.max(dp[i][j][t], val);
                    }
                }
            }
        }

        return dp[n][m][k];
    }
}