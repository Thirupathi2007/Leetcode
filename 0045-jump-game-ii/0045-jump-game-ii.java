class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int lastJumpEnd = 0;
        int farthest = 0;
        
        // Iterate through the array, but not the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable from current index
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we reached the end of the current jump range
            if (i == lastJumpEnd) {
                jumps++;
                lastJumpEnd = farthest;
                
                // Optional optimization: if we can reach the end, break early
                if (lastJumpEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}