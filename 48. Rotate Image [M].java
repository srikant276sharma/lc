48. Rotate Image [M]
https://leetcode.com/problems/rotate-image/

/* First transpose the matrix and then swap row wise.

TC: O(N^2), where N is the number of rows in the matrix.
SC: O(1).
*/

class Solution {
    public void rotate(int[][] matrix) {

        /*At first transpose the matrix, swap(a[i][j], a[j][i]) */
        int temp = 0;
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /*Then flip the matrix symmetrically, swap(a[i][j], a[i][a.length - 1 - j]) */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
