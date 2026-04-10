class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current position is unreachable, return false
            if (i > maxReach) {
                return false;
            }
            // Update the furthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Optimization: if maxReach already covers the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}