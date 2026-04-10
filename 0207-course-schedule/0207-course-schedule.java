import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the graph (adjacency list) and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // Pre[1] must be taken before Pre[0] (Pre[1] -> Pre[0])
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        // 2. Add all courses with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 3. Process the queue
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;

            // For each dependent course
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // 4. If count equals numCourses, no cycles
        return count == numCourses;
    }
}