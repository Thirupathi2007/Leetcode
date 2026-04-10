class Solution {
    public String reverseWords(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();
        // Split the string into words using whitespace as delimiter
        String[] words = s.split("\\s+");
        // Reverse the words and join them with single spaces
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}