class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                          List<Integer> current, List<List<Integer>> result) {
        // Base case: if target is 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // If target becomes negative, stop exploring this path
        if (target < 0) {
            return;
        }
        
        // Try each candidate starting from 'start' index
        for (int i = start; i < candidates.length; i++) {
            // Choose: add candidate to current combination
            current.add(candidates[i]);
            
            // Explore: recurse with reduced target
            // Use 'i' (not 'i+1') to allow reusing the same number
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // Unchoose: backtrack
            current.remove(current.size() - 1);
        }
    }
}