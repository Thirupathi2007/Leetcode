class Solution {
    public int coinChange(int[] coins, int amount) {
        // Step 1: Initialize DP array with a value greater than any possible result
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, max);
        
        // Step 2: Base case - 0 coins needed for amount 0
        dp[0] = 0;
        
        // Step 3: Iterate through all amounts from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // Check if the current coin can be used
                if (coin <= i) {
                    // Update dp[i] with the minimum of current value or (dp[i-coin] + 1)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // Step 4: Return result based on whether the amount was reachable
        return dp[amount] > amount ? -1 : dp[amount];
    }
}