class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add current subset to result
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if current number equals previous and we haven't used previous
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include nums[i]
            current.add(nums[i]);
            // Recurse with next index
            backtrack(result, current, nums, i + 1);
            // Backtrack: remove nums[i]
            current.remove(current.size() - 1);
        }
    }
}