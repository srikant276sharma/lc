787. Cheapest Flights Within K Stops [M]
https://leetcode.com/problems/cheapest-flights-within-k-stops/

/* Solution 1: Using Dijkstra's algorithm.
https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/tutorial/
KC: https://www.youtube.com/watch?v=IQOG3w4abAg

TC: 
SC: 

Asked by:
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        //creating adjacency list for source cities.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            //source city: [destination city, source to destination cost].
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        //MinHeap: input format: [city, distance, cost], it compares based on cost.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int city = cur[0], distance = cur[1], cost = cur[2];

            if (city == dst) {
                return cost;
            }
            if (distance <= K) {
                //add adjacent nodes.
                for (int[] adjNode : graph.get(city)) {
                    minHeap.add(new int[]{adjNode[0], distance + 1, cost + adjNode[1]});
                }
            }
        }

        return -1;
    }
}
