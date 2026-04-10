class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        // Iterate through every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If land is found, initiate DFS to calculate area
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Boundary checks and water (0) check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // Mark current cell as visited by setting it to 0
        grid[r][c] = 0;

        // Count current cell (1) + recursively check 4 directions
        return 1 + dfs(grid, r + 1, c) + 
                   dfs(grid, r - 1, c) + 
                   dfs(grid, r, c + 1) + 
                   dfs(grid, r, c - 1);
    }
}