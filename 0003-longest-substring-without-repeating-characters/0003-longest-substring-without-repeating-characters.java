class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            // If character is already in the window, move left pointer
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }
            
            // Update the character's most recent index
            charIndex.put(c, right);
            
            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}