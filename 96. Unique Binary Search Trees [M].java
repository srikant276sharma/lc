96. Unique Binary Search Trees [M]
https://leetcode.com/problems/unique-binary-search-trees/

/* Solution 1: Using Dynamic Programming.
Vivekanand: https://www.youtube.com/watch?v=kT_VabdscHk

TC: O(n^2), where n is the input number.
SC: O(n).
*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; //we're considering 0 as well, so added 1.
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; //dp[5] = dp[0] * dp[5 - 0 - 1] ..
            }
        }

        return dp[n];
    }
}
