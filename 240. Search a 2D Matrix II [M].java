240. Search a 2D Matrix II [M]
https://leetcode.com/problems/search-a-2d-matrix-ii/

/* Solution 1: Start searching from top right corner. For higher values go Down && for lower values go Left.

Time Complexity: O(n + k), where n = number of rows and k = no. of columns.
Space Complexity: O(1).
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length,
                row = 0, col = cols - 1; //Starting from top right corner.
        //for higher values go Down && for lower values go Left.
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
