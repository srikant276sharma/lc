441. Arranging Coins [E]
https://leetcode.com/problems/arranging-coins/

/*Solution 1. Using Math.
1 + 2 + 3 + ... k = k(k + 1)/2
So, in this case, k(k + 1)/2 <= N

TC: O(1).
SC: O(1).

Asked by:
*/

class Solution {
    public int arrangeCoins(int n) {
        int res = (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
        return res;
    }
}
