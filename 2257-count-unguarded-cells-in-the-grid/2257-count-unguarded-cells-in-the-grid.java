class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }
        
        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }
        
        // Directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // Process each guard
        for (int[] g : guards) {
            int r = g[0], c = g[1];
            
            for (int[] d : dirs) {
                int x = r + d[0];
                int y = c + d[1];
                
                while (x >= 0 && x < m && y >= 0 && y < n &&
                       grid[x][y] != 1 && grid[x][y] != 2) {
                    
                    if (grid[x][y] == 0) {
                        grid[x][y] = 3; // mark guarded
                    }
                    
                    x += d[0];
                    y += d[1];
                }
            }
        }
        
        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}