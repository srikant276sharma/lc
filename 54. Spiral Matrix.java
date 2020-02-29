54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/

/*Solution 1.
- First process TOP > RIGHT > BOTTOM > LEFT.
- then repeat the same. 
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return nums;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while (nums.size() < size) {
            for (int i = left; i <= right && nums.size() < size; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && nums.size() < size; i++) {
                nums.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && nums.size() < size; i--) {
                nums.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && nums.size() < size; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
        }
        return nums;
    }
}

--
Time complexity: O(n) where n is the number of cells in the matrix.
Space complexity: O(n) where n is the number of cells in the matrix.
--
Asked by: Amazon, Apple, Facebook, Google, Snapchat, Microsoft, Oracle, Adobe, Goldman Sachs, Visa and Epic Systems.
--
