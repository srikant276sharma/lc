309. Best Time to Buy and Sell Stock with Cooldown [M]
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

/*Solution 1: Using Dynamic Programming.
KC: https://www.youtube.com/watch?v=pkiJyNijgBw

TC: O(n).
SC: O(1).
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int A = 0, //Hold or Buy.
                B = -prices[0], //Hold or Sell.
                C = 0; //Hold.

        for (int i = 1; i < prices.length; i++) {
            int tmp = A;
            A = Math.max(A, C); //A or C holds the stock.
            C = B + prices[i]; //B sells the stock.
            B = Math.max(B, tmp - prices[i]); //B holds the stock or A buys the stock.
        }

        return Math.max(A, C);
    }
}
