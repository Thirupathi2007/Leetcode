class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters in the string to use as key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // Add the original string to the list for this sorted key
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        
        // Return all the grouped anagrams
        return new ArrayList<>(map.values());
    }
}