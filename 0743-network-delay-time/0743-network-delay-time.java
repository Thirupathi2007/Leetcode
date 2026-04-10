import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // 2. Min-Heap for Dijkstra: {time_from_k, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // 3. Keep track of minimum time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();

        // 4. Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if (dist.containsKey(node)) continue;
            dist.put(node, time);

            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int travelTime = edge[1];
                    if (!dist.containsKey(neighbor)) {
                        pq.offer(new int[]{time + travelTime, neighbor});
                    }
                }
            }
        }

        // 5. Check if all nodes were reached
        if (dist.size() != n) return -1;

        // 6. Return the maximum time among all shortest paths
        int maxTime = 0;
        for (int time : dist.values()) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
