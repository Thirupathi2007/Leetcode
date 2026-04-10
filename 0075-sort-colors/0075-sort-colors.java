class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while (mid <= right) {
            if (nums[mid] == 0) {
                // Swap with left pointer
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 2) {
                // Swap with right pointer
                swap(nums, mid, right);
                right--;
            } else {
                // nums[mid] == 1, just move forward
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}