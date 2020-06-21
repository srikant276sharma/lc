174. Dungeon Game [H]
https://leetcode.com/problems/dungeon-game/

/** Solution 1: Using Dynamic Programming.
KC: https://www.youtube.com/watch?v=LbC0ejgACkE

TC: O(m * n), where m = no. of rows and n = no. of cols.
SC: O(m * n)
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];

        //start from Bottom Right cell.
        dp[rows - 1][cols - 1] = (dungeon[rows - 1][cols - 1] > 0) ? 1 : (1 - dungeon[rows - 1][cols - 1]);

        //last col processing, starting from bottom towards top.
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1] - dungeon[i][cols - 1], 1);
        }
        //last row processing, starting from right towards left. 
        for (int i = cols - 2; i >= 0; i--) {
            dp[rows - 1][i] = Math.max(dp[rows - 1][i + 1] - dungeon[rows - 1][i], 1);
        }
        //bottom right to top left processing.
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                //take min between right and bottom cells and subtract cur dungeon cell value.
                dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
