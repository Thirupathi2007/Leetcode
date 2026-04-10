import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            // Step 1: frequency map
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            
            // Step 2: convert to list
            List<int[]> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new int[]{key, map.get(key)});
            }
            
            // Step 3: sort
            Collections.sort(list, (a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // freq desc
                return b[0] - a[0]; // value desc
            });
            
            // Step 4: take top x
            int sum = 0;
            int count = 0;
            
            for (int[] pair : list) {
                if (count == x) break;
                
                sum += pair[0] * pair[1];
                count++;
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}