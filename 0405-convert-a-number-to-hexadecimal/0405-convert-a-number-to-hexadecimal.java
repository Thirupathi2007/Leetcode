class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        String hex = "0123456789abcdef";
        StringBuilder result = new StringBuilder();
     
        long n = num & 0xffffffffL;
        
        while (n > 0) {
            result.append(hex.charAt((int)(n % 16)));
            n /= 16;
        }
        
        return result.reverse().toString();
    }
}