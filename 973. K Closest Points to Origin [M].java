973. K Closest Points to Origin [M]
https://leetcode.com/problems/k-closest-points-to-origin/

/*Solution 1.
Using Max-heap.
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] kClosestPts = new int[K][2];
        if (points == null || points.length == 0) {
            return kClosestPts;
        }
        /*MaxHeap. */
        /*Euclidean distance: D = sqrt[ (x2 - x1)^2 + (y2 - y1)^2 ] */
        /*Distance between (X,Y) and Origin (0,0) is D^2 => (X-0)^2 + (Y-0)^2 => X^2 + Y^2 */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < K; i++) {
            kClosestPts[i] = maxHeap.poll();
        }

        return kClosestPts;
    }
}

--
Time complexity: O(n log k) where n is the no. of distinct elements in the array and k is the closest point count.
 Each element is processed in O(log k) time, which is the time to add or to remove the maximum element from the heap.
 Therefore, if there are n distinct elements in the input, the TC to process all of them is O(n log k).

Space complexity: O(k) to store k elements in the Max-heap.
--
Asked by: Amazon, Google, Facebook.
--
