class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                          int[] nums, boolean[] used) {
        // Base case: if we've used all numbers, add the permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip if already used
            if (used[i]) continue;
            
            // Skip duplicates: if current number equals previous and previous hasn't been used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            // Choose
            current.add(nums[i]);
            used[i] = true;
            
            // Explore
            backtrack(result, current, nums, used);
            
            // Unchoose
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}