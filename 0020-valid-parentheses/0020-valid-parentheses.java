class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Push opening brackets onto the stack
                stack.push(c);
            } else {
                // Check closing brackets
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Verify the closing bracket matches the opening bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty if all brackets are matched
        return stack.isEmpty();
    }
}