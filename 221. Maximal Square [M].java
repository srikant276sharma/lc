221. Maximal Square [M]
https://leetcode.com/problems/maximal-square/

/* Solution 1: Using Dynamic Programming: Top-Down approach.
Tushar: https://www.youtube.com/watch?v=_Lf1looyJMU
Knowledge Center: https://www.youtube.com/watch?v=Bw8ItQLw868&t=10s

Time complexity: O(mn).
Space complexity: O(mn).

Similar problems:
1277. Count Square Submatrices with All Ones [M]
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Copy first row and first column as it is.
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        //NOTE: (Min among Up, Diagonal, Left elements) + 1.
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
        }

        return maxSide * maxSide;
    }
}

--
Asked by: Amazon, Facebook, Google.
--
