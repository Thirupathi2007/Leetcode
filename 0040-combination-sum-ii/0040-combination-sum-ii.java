import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Step 1: sort
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> temp, List<List<Integer>> result) {
        
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Stop if current number exceeds target
            if (candidates[i] > target) {
                break;
            }

            // Choose
            temp.add(candidates[i]);

            // Move to next index (i+1 because single use)
            backtrack(candidates, target - candidates[i], i + 1, temp, result);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}