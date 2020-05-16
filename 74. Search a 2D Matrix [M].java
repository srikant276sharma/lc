74. Search a 2D Matrix [M]
https://leetcode.com/problems/search-a-2d-matrix/

/* Solution 1: Using Binary Search.

Time Complexity: O(n log k), where n = number of rows and k = no. of columns (Need to verify).
Space Complexity: O(1).
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            //Check only in those rows where target can exist.
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                //Use Binary Search to find the target.
                int low = 0, high = cols - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return false;
    }
}
