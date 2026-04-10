import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a Max-Heap to keep track of the k closest points
        // The heap stores points, and we compare them based on squared distance: x^2 + y^2
        // A Max-Heap allows us to remove the point with the largest distance among the k candidates
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            maxHeap.add(point);
            // If heap size exceeds k, remove the point furthest from the origin
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Convert the heap into the required result array
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;
    }
}