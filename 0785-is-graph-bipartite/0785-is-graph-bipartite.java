class Solution {
    public boolean isBipartite(int[] [] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        // -1 means unvisited, 0 and 1 are the two colors
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        
        // Check each component (graph may not be connected)
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int start, int[] [] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    // Color with opposite color
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // Same color as current node - not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
}