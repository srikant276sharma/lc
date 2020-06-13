1475. Final Prices With a Special Discount in a Shop [E]
https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

/* Solution 1: Using 2 pointers.

TC: O(n^2), where n is the length of input array.
SC: O(1).

Asked by: 
*/

class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;

        //there is no need to process the last element, so len - 1.
        for (int i = 0; i < len - 1; i++) { 
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}
