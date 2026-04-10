class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values for first pointer
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Early termination if minimum possible sum is too large
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicate values for second pointer
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Early termination for inner loop
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}