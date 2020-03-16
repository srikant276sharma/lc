695. Max Area of Island [M]
https://leetcode.com/problems/max-area-of-island/

/*Solution 1.
Using DFS.

Algorithm:
 Loop through our int[][] grid, and for each piece of land we see (a 1), we mark all the land it's connected to and also count the connected land.
 We mark land by setting true in visited array.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        int islandArea = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                islandArea = dfs(grid, i, j, visited);
                if (islandArea > maxArea) {
                    maxArea = islandArea;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        count += dfs(grid, i - 1, j, visited); //Up.
        count += dfs(grid, i, j + 1, visited); //Right.
        count += dfs(grid, i + 1, j, visited); //Down.
        count += dfs(grid, i, j - 1, visited); //Left.
        return count;
    }
}

--
Time complexity: O(Rows * Cols)
Space complexity: O(Rows * Cols) due to Recursion.
--
Asked by: Google, Facebook, Microsoft, Amazon, Uber, DoorDash, Qualtrics, Affirm.
--
