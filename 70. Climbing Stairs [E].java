70. Climbing Stairs [E]
https://leetcode.com/problems/climbing-stairs/
Tushar: https://www.youtube.com/watch?v=CFQk7OQO_xM

/* Solution 1:
Using Dynamic Programming.
Formula: f(n) = f(n - 1) + f(n - 2)
*/

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int n1 = 1;
        int n2 = 2;
        int distinctWays = 0;

        for (int i = 3; i <= n; i++) {
            distinctWays = n1 + n2;
            n1 = n2;
            n2 = distinctWays;
        }

        return n2;
    }
}

--
Time complexity : O(n), Single pass.
Space complexity: O(1), Constant space needed.
--
Asked by: Microsoft, Google, Alibaba, Bloomberg, Amazon, Goldman Sachs, Walmart Labs, LinkedIn.
--
