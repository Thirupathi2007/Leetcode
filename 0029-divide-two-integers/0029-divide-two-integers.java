public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case: overflow
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        
        // Work with absolute values using long to avoid overflow
        long dividend_abs = Math.abs((long)dividend);
        long divisor_abs = Math.abs((long)divisor);
        
        int result = 0;
        
        // Use bit shifting to find the quotient
        while (dividend_abs >= divisor_abs) {
            int shift = 0;
            // Find the largest shift where (divisor << shift) <= dividend
            while (dividend_abs >= (divisor_abs << (shift + 1))) {
                shift++;
            }
            // Subtract the shifted divisor and add to result
            result += (1 << shift);
            dividend_abs -= (divisor_abs << shift);
        }
        
        return result * sign;
    }
}