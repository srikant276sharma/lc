322. Coin Change [M]
https://leetcode.com/problems/coin-change/

/* Solution 1: Using Dynamic programming.
Tushar: https://www.youtube.com/watch?v=NJuKJ8sasGk
B2B: https://www.youtube.com/watch?v=jgiZlGzXMBw&t=50s
Kevin: https://www.youtube.com/watch?v=1R0_7HqNaW0

Time complexity: O(amount * coins).
Space complexity: O(amount).
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i] always holds min coins count we need for amount i.
        int[] dp = new int[amount + 1]; //Considering 0 as well so added one more element.

        for (int i = 1; i <= amount; i++) {
            int minCoin = amount + 1; //anything greater than amount.

            for (int coin : coins) {
                //if coin denomination is <= current amount then only we can use the coin.
                if (coin <= i) {
                    //Take minimum between, excluding the current coin and including the current coin.
                    minCoin = Math.min(minCoin, 1 + dp[i - coin]);
                }
            }
            dp[i] = minCoin;
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
