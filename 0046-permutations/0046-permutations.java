class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        // Base case: if current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try adding each number that hasn't been used yet
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(result, current, nums);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
}