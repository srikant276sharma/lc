867. Transpose Matrix [E]
https://leetcode.com/problems/transpose-matrix/

/* Solution 1:
*/

class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[c][r] = A[r][c];
            }
        }

        return result;
    }
}

--
Complexities:
Time: O(R∗C), where R and C are the number of rows and columns in the given matrix A.
Space: O(R∗C), the space used by the result.
--
Asked by:
--
