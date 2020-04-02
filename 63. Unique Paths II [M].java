63. Unique Paths II [M]
https://leetcode.com/problems/unique-paths-ii/

/*Solution 1: 
  Using Dynamic programming.
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        /*Starting cell processing. */
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }

        /*First row processing. */
        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                /*Assign previous cell value. */
                dp[0][i] = dp[0][i - 1];
            }
        }

        /*First column processing. */
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                /*Assign previous cell value. */
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    /*Combine Upper (for Down move) and Left (for Right move) cell values. */
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}

--
Time complexity:  O(m*n), where m is number of rows, n is number of columns in the array.
Space complexity: O(m*n), where m is number of rows, n is number of columns in the array.
--
Asked by: Google.
--
