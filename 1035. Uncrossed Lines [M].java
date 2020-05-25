1035. Uncrossed Lines [M]
https://leetcode.com/problems/uncrossed-lines/

/* Solution 1: Using Dynamic Programming: Top-Down approach.
Knowledge Center: https://www.youtube.com/watch?v=jLv-5coG-qQ

Time complexity: O(mn).
Space complexity: O(mn).

Similar:
1143. Longest Common Subsequence [M]

Asked by:
*/

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                dp[i][j] = (A[i - 1] == B[j - 1]) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[aLen][bLen];
    }
}
