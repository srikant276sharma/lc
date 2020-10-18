54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/

/*Solution 1.
- First process TOP > RIGHT > BOTTOM > LEFT.
- then repeat the same. 
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //input check.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, right = cols - 1, bottom = rows - 1, left = 0;
        
        while (left <= right && top <= bottom) {
            //top left to right processing.
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            //right top to bottom processing.
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //bottom right to left processing.
            if (left <= right && top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //left bottom to top processing.
            if (left <= right && top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}

--
Time complexity: O(n) where n is the number of cells in the matrix.
Space complexity: O(n) where n is the number of cells in the matrix.
--
Asked by: Amazon, Apple, Facebook, Google, Snapchat, Microsoft, Oracle, Adobe, Goldman Sachs, Visa and Epic Systems.
--
