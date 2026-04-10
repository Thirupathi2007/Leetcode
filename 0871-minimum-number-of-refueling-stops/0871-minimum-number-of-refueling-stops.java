import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max heap (reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int prev = 0;
        int stops = 0;

        for (int[] station : stations) {
            int position = station[0];
            int gas = station[1];

            // Fuel used to reach this station
            fuel -= (position - prev);

            // Refuel if needed
            while (fuel < 0) {
                if (maxHeap.isEmpty()) return -1;
                fuel += maxHeap.poll();
                stops++;
            }

            // Add this station's fuel as an option
            maxHeap.offer(gas);
            prev = position;
        }

        // Try to reach target
        fuel -= (target - prev);

        while (fuel < 0) {
            if (maxHeap.isEmpty()) return -1;
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}