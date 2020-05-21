1277. Count Square Submatrices with All Ones [M]
https://leetcode.com/problems/count-square-submatrices-with-all-ones/

/* Solution 1: Using Dynamic programming.

Time complexity: O(mn).
Space complexity: O(mn).

Similar problems: 
221. Maximal Square [M]
*/

class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int squareCount = 0;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Copy first row and first column as it is.
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = matrix[i][j];
                        squareCount += dp[i][j];
                    }
                } else {
                    if (matrix[i][j] == 1) {
                        //Square count = Min among top, left and top left + 1.
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        squareCount += dp[i][j];
                    }
                }
            }
        }

        return squareCount;
    }
}
