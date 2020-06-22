121. Best Time to Buy and Sell Stock [E]
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/* Solution 1: Using minPrice and maxProfit.
Algorithm:
1. Iterate through the array. While iterating, keep track of 2 variables,
   minPrice representing the minimum value you've seen so far
   maxProfit representing the maximum profit that can be generated (through a buy/sell) so far.
2. Return maxProfit.

TC: O(n), where n is the number of elements in the input array.
SC: O(1).
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
