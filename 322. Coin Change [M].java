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
        //minCoins[i] always holds min coins count we need for amount i.
        int[] minCoins = new int[amount + 1];
        minCoins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE - 1;
        }

        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //if current amount is >= coin denomination then only we can use the coin.
                if (i >= coins[j]) {
                    //Min between, excluding the current coin or including the current coin.
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                } else {
                    break;
                }
            }
        }

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }
}
