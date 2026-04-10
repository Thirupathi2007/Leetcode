class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Place each number in its correct index (num -> index num-1)
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 &&
                nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                int correctIndex = nums[i] - 1;

                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first index where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are correct
        return n + 1;
    }
}