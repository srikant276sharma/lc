122. Best Time to Buy and Sell Stock II [E]
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Kevin: https://www.youtube.com/watch?v=blUwDD6JYaE

/* Solution 1:
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}

--
Time complexity : O(n), Single pass.
Space complexity: O(1), Constant space needed.
--
Asked by: Adobe, Microsoft, Facebook, Alibaba, Bloomberg, Amazon.
--
