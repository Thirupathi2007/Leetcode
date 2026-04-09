class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // Create lists to store characters for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int currentRow = 0;
        int direction = 1; // 1 for down, -1 for up
        
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            
            // Change direction at top and bottom rows
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }
            
            currentRow += direction;
        }
        
        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}