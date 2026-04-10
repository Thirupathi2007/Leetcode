class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Mapping of digits to letters
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, 
                          List<String> result, String[] mapping) {
        // Base case: we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters that the current digit maps to
        String letters = mapping[digits.charAt(index) - '0'];
        
        // Try each letter
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result, mapping);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}