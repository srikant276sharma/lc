518. Coin Change 2 [M]
https://leetcode.com/problems/coin-change-2/

/* Solution 1: Using Top Down Dynamic Programming. Combine 2 choices, exclude the coin and include the coin.

Jenny: https://www.youtube.com/watch?v=L27_JpN6Z1Q
Vivekanand: https://www.youtube.com/watch?v=ZaVM057DuzE&feature=youtu.be
B2B: https://www.youtube.com/watch?v=DJ4a7cmjZY0
Tushar: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChanging.java

TC: O(A * C), where A is amount and C is number of coins.
SC: O(A * C).

Asked by:
*/

class Solution {
    public int change(int amount, int[] coins) {
        int rows = coins.length + 1, cols = amount + 1;
        int[][] ways = new int[rows][cols];

        //in case of amount = 0, irrespective of coins, there is always a way which is by not including any coin.
        for (int i = 0; i < rows; i++) {
            ways[i][0] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                //if coin denomination is greater than amount, then copy the upper value (which means exclude the current coin).
                if (coins[i - 1] > j) {
                    ways[i][j] = ways[i - 1][j];
                } else {
                    //combine the 2 choices, exclude the coin and include the coin.
                    ways[i][j] = ways[i - 1][j] + ways[i][j - coins[i - 1]];
                }
            }
        }

        return ways[rows - 1][cols - 1];
    }
}
