class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        
        int prevTime = neededTime[0];
        
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // remove smaller one
                totalTime += Math.min(prevTime, neededTime[i]);
                
                // keep the larger time
                prevTime = Math.max(prevTime, neededTime[i]);
            } else {
                prevTime = neededTime[i];
            }
        }
        
        return totalTime;
    }
}