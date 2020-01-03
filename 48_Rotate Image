48. Rotate Image.
https://leetcode.com/problems/rotate-image/
--
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
--
