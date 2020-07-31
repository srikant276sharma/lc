70. Climbing Stairs [E]
https://leetcode.com/problems/climbing-stairs/

/* Solution 1: Using Dynamic Programming.
Formula: f(n) = f(n - 1) + f(n - 2)
Tushar: https://www.youtube.com/watch?v=CFQk7OQO_xM

TC: O(n), Single pass.
SC: O(1), Constant space needed.

Asked by: Microsoft, Google, Alibaba, Bloomberg, Amazon, Goldman Sachs, Walmart Labs, LinkedIn.
*/

class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int x = 1, y = 2, distinctWays = 0;
        for (int i = 3; i <= n; i++) {
            distinctWays = x + y;
            x = y;
            y = distinctWays;
        }
        return distinctWays;
    }
}
