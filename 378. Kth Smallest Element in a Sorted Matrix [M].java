378. Kth Smallest Element in a Sorted Matrix [M]
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

/* Solution 1: Using Max-Heap.

TC: O(n log k), where n is no. of elements in matrix and k is size of Max-heap.
    Each element is processed in O(log k) time, which is the time to add or to remove the maximum element from the heap.
    Therefore, if there are n elements in the matrix, the TC to process all of them is O(n log k).

Space: O(k) to store k elements in the Max-heap.

Asked by:
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int rows = matrix.length,
                cols = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maxHeap.size() == k && matrix[i][j] > maxHeap.peek()) {
                    continue;
                }
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek();
    }
}
