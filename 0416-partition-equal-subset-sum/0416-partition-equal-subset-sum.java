class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, can't split equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[j] = true if subset sum j is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // Traverse backwards to avoid reuse
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}