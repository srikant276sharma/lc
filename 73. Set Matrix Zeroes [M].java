73. Set Matrix Zeroes [M]
https://leetcode.com/problems/set-matrix-zeroes/

/* Solution 1:
Amell: https://www.youtube.com/watch?v=1KnLIAvTxjQ

Time complexity: O(mn), where m = no of rows and n = no of columns.
Space complexity: O(1).
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean isFirstRowZero = false, isFirstColZero = false;

        //Check if 1st Row has a 0.
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        //Check if 1st Col has a 0.
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        //If any cell has a 0, mark 1st Row and 1st Col as 0.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; //Mark 1st Row as 0.
                    matrix[i][0] = 0; //Mark 1st Col as 0.
                }
            }
        }

        //If 1st Row or 1st Col is 0, then mark current cell as 0.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Set entire 1st Row as 0.
        if (isFirstRowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        //Set entire 1st Col as 0.
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
