64. Minimum Path Sum [M]
https://leetcode.com/problems/minimum-path-sum/

/*Solution 1.
 Using Dynamic Programming.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        /*Build DP array. */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    /*Add min of Up and Left elements. */
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        /*Return bottom right element. */
        return dp[rows - 1][cols - 1];
    }
}

--
Time Complexity: O(M*N), where M is no. of rows and N is no. of columns.
Space Complexity: O(M*N), where M is no. of rows and N is no. of columns.
--
Asked by: Amazon.
--
