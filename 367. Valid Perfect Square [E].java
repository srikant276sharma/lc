367. Valid Perfect Square [E]
https://leetcode.com/problems/valid-perfect-square/

/* Solution 1: Using Binary Search.
https://leetcode.com/problems/valid-perfect-square/discuss/459934/O(log-n)-BINARY-SEARCH-%2B-NEWTON'S-METHOD

Time complexity: O(log n).
Space complexity: O(1).

Asked by:
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int low = 0, high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long squared = (long) mid * mid; //Use long to avoid integer overflow.
            if (squared == num) {
                return true;
            }
            if (squared < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
