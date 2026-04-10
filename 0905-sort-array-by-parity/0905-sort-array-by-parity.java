class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // Case: left is odd and right is even -> Swap
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
            // Move left pointer forward if it points to an even number
            if (nums[left] % 2 == 0) left++;
            // Move right pointer backward if it points to an odd number
            if (nums[right] % 2 == 1) right--;
        }
        
        return nums;
    }
}