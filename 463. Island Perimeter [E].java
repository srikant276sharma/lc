463. Island Perimeter [E]
https://leetcode.com/problems/island-perimeter/

/*Solution 1.
Algorithm:
If Upper neighbour is 1 then there is a common border between them so subtracting 2.
If Left neighbour is 1 then there is a common border between them so subtracting 2.
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1) { //Upper cell.
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) { //Left cell.
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }
}

/*Solution 2: By checking connected cells.
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - connectionsCount(grid, i, j));
                }
            }
        }
        return perimeter;
    }

    private int connectionsCount(int[][] grid, int i, int j) {
        int count = 0;
        int row, col;
        int[] directions = new int[]{0, -1, 0, 1, 0}; //Left, Up, Right, Down.
        for (int d = 0; d < directions.length - 1; d++) {
            row = i + directions[d];
            col = j + directions[d + 1];
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
                continue;
            }
            count++;
        }
        return count;
    }
}

--
Time complexity: O(Rows * Cols)
Space complexity: O(1).
--
Asked by:
--
