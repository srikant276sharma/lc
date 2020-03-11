973. K Closest Points to Origin [M]
https://leetcode.com/problems/k-closest-points-to-origin/

/*Solution 1.
Using Max-heap.
*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /*MaxHeap. */
        /*Euclidean distance: D = sqrt[ (x2 - x1)POW2 + (y2 - y1)POW2 ] */
        /*Distance between (X,Y) and Origin (0,0) is Dpow2 => (X-0) pow2 + (Y-0) pow2 => X pow2 + Y pow2 */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];
        while (K-- > 0) {
            result[K] = maxHeap.poll();
        }
        return result;
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
