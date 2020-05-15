918. Maximum Sum Circular Subarray [M]
https://leetcode.com/problems/maximum-sum-circular-subarray/

/* Solution 1: Using Kadane's algorithm.
Knowledge Center: https://www.youtube.com/watch?v=os4B7MlHAbs&t=12s

Time: O(N), where N is number of elements in input array.
Space: O(1).

Asked by:
*/

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0,
                maxEndingAt = 0, minEndingAt = 0,
                maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;

        for (int x : A) {
            totalSum += x;
            maxEndingAt = Math.max(maxEndingAt + x, x);
            maxSum = Math.max(maxSum, maxEndingAt);

            minEndingAt = Math.min(minEndingAt + x, x);
            minSum = Math.min(minSum, minEndingAt);
        }

        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }
        //To handle a case where all are -ve elements.
        return maxSum;
    }
}
