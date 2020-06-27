279. Perfect Squares [M]
https://leetcode.com/problems/perfect-squares/

/** Solution 1: Using Dynamic Programming.
KC: https://www.youtube.com/watch?v=dOOzOsfj31I

TC: O(n*sqrt{n}). In main step, we have a nested loop, where the outer loop is of n iterations and in the inner loop it takes at maximum sqrt{n}​ iterations.
SC: O(n). We keep all the intermediate sub-solutions in the array dp[].

Asked by: 4.
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; //Considering 0 as well.

        for (int i = 1; i <= n; i++) {
            int minVal = i; //Take all 1's.

            int j = 1, square = 1;
            while (square <= i) {
                minVal = Math.min(minVal, 1 + dp[i - square]);
                j++;
                square = j * j;
            }
            dp[i] = minVal;
        }
        return dp[n];
    }
}
