509. Fibonacci Number [E]
https://leetcode.com/problems/fibonacci-number/
Tushar: https://www.youtube.com/watch?v=CFQk7OQO_xM

/* Solution 1:
Using Dynamic Programming.
Formula: f(n) = f(n - 1) + f(n - 2)
*/

class Solution {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        int n1 = 0;
        int n2 = 1;
        int fibNum = 0;

        /* Initialize i with n2 + 1 because n2 is already processed. */
        for (int i = 2; i <= N; i++) {
            fibNum = n1 + n2;
            n1 = n2;
            n2 = fibNum;
        }

        return n2;
    }
}

--
Time complexity : O(n), Single pass.
Space complexity: O(1), Constant space needed.
--
Asked by:
--
