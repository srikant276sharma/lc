55. Jump Game [M]
https://leetcode.com/problems/jump-game/

/* Solution 1: Iterative.
Algorithm:
 Notice we never progress backwards in the array, as jumps are only forward. Iterate left-to-right through the array.
 For each index i in the array, see what the maximum jump reach you have.
 As long as there are elements within reach that we haven't tried, keep going until you reach the end of the array. If we get to end, return true. If not, return false.

Rodney: https://leetcode.com/problems/jump-game/discuss/323971/O(N)-TIME-O(1)-JAVA-SOLUTION-ITERATIVE
*/

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int canReach = 0;
        for (int i = 0; i <= canReach; i++) {
            canReach = Math.max(canReach, i + nums[i]);
            if (canReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}

--
Complexities:
Time: O(n).
Space: O(1).
--
Asked by:
--
