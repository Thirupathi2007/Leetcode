class Solution {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the largest index i such that nums[i] < nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: If no such index exists, reverse the entire array
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // Step 3: Find the largest index j > i such that nums[i] < nums[j]
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }
        
        // Step 4: Swap nums[i] and nums[j]
        swap(nums, i, j);
        
        // Step 5: Reverse the suffix starting at nums[i+1]
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}