class Solution {
    public int climbStairs(int n) {
        // Base cases: if n is 1 or 2, the answer is n itself.
        if (n <= 2) {
            return n;
        }

        int first = 1;  // Ways to reach step 1
        int second = 2; // Ways to reach step 2

        // Calculate ways for each step from 3 up to n
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}