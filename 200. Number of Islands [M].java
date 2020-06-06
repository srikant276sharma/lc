200. Number of Islands [M]
https://leetcode.com/problems/number-of-islands/

/*Solution 1.
Using DFS.

Algorithm:
 Loop through our char[][] grid, and for each piece of land we see (a 1), we mark all the land it's connected to.
 We mark land by setting true in visited array.
 
TC: O(Rows * Cols)
SC: O(Rows * Cols) due to Recursion.

Asked by: Amazon, Facebook, Lyft, Uber, LinkedIn, Google, Microsoft, Bloomberg, Alibaba, Apple, eBay, Oracle, Adobe, Qualtrics, AppDynamics.
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
		/*Check: water and visited cell. */
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                dfs(grid, i, j, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        /*Check: Edge cases, water and visited cell. */
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited); //Up.
        dfs(grid, i, j + 1, visited); //Right.
        dfs(grid, i + 1, j, visited); //Down.
        dfs(grid, i, j - 1, visited); //Left.
    }
}
