class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        
        // Step 1: Skip leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        // Step 2: Check for sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        // Step 3: Read digits and convert
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Check for overflow before multiplying
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }
}