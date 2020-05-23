986. Interval List Intersections [M]
https://leetcode.com/problems/interval-list-intersections/

/* Solution 1: Using 2 pointers.

Time complexity: O(M + N), where M, N are the lengths of A and B respectively.
Space complexity: O(M + N), the maximum size of the output list.

Asked by: Amazon, Facebook, Google.
*/

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            //Check if A[i] intersects B[j] or not.
            //low = the starting point of intersection.
            //high = the ending point of intersection.
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if (low <= high) {
                list.add(new int[]{low, high});
            }

            //Remove the interval with the smallest endpoint.
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
