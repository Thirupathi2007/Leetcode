class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;
        
        // Binary search on the smaller array
        int left = 0;
        int right = m;
        
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = half - partition1;
            
            // Get the four values around the partition
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if (total % 2 == 1) {
                    // Odd total length - median is the smaller of the two right elements
                    return Math.min(minRight1, minRight2);
                } else {
                    // Even total length - median is average of the two middle elements
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // Move left partition to the left
                right = partition1 - 1;
            } else {
                // Move left partition to the right
                left = partition1 + 1;
            }
        }
        
        // Should never reach here
        throw new IllegalArgumentException("Arrays are not sorted");
    }
}