62. Unique Paths [M]
https://leetcode.com/problems/unique-paths/

/*Solution 1. Using Dynamic Programming.
Tushar: https://www.youtube.com/watch?v=GO5QHC_BmvM
Kevin: https://www.youtube.com/watch?v=6qMFjFC9YSc

TC: O(M*N), where M is no. of rows and N is no. of columns.
SC: O(M*N), where M is no. of rows and N is no. of columns.

Asked by: Amazon, Google, Facebook, Goldman Sachs, Adobe.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        /*First row and first column cell values will be 1 because there is only one path. */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    /*Combining Upper (for Down move) and Left (for Right move) cell values. */
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
