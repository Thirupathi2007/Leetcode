class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if we've used all pairs, add to result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add opening parenthesis if we haven't reached the limit
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Add closing parenthesis if it doesn't exceed opening count
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}