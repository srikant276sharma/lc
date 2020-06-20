994. Rotting Oranges [M]
https://leetcode.com/problems/rotting-oranges/

/*Solution 1. classic BFS: 
keep adding rotten oranges at each level 
and for every rotten orange, modify its adjacent fresh oranges to rotten 
and keep adding them to queue till there are no more rotten oranges.

TC: O(n) where n is the number of cells in the grid.
SC: O(n) for queue space.

Asked by: Amazon, Flipkart.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    /* add location of rotten oranges to queue in the first level */
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    /* count of fresh oranges. this is useful for us (in the end) to check if all the fresh oranges have rotten or not and return the value accordingly */
                    freshOranges++;
                }
            }
        }

        /* this is basically number of levels in BFS / level order traversal */
        int mins = 0;
        /* all the possible adjacent directions of a grid value: Up, Down, Left, Right */
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /* continue the BFS till there are no more valid fresh oranges that can rotten */
        while (!queue.isEmpty() && freshOranges > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = queue.poll();
                for (int[] dir : directions) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];

                    /* exceeded the boundary or the grid value is not a fresh orange, in that case just continue the loop */
                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    /* mark the orange from fresh -> rotten */
                    grid[x][y] = 2;
                    /* add the location of rotten orange to queue */
                    queue.offer(new int[]{x, y});
                    freshOranges--;
                }
            }
            /* increment the level */
            mins++;
        }
        /* fact that there are no fresh oranges in the grid means all the fresh oranges in the grid have been rotten */
        return freshOranges == 0 ? mins : -1;
    }
}
