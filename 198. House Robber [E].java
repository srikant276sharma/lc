198. House Robber [E]
https://leetcode.com/problems/house-robber/
Tushar: https://www.youtube.com/watch?v=UtGtF6nc35g

/* Solution 1:
Using Dynamic Programming.
*/

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int inclusive = nums[0];
        int exclusive = 0;
        int temp = 0;

        for (int i = 1; i < nums.length; i++) {
            temp = inclusive;
            inclusive = Math.max(exclusive + nums[i], inclusive);
            exclusive = temp;
        }

        return inclusive;
    }
}

--
Time Complexity: O(n), where n is number of elements in the array.
Space Complexity: O(1), Only constant space is used.
--
Asked by: Google, Amazon, Adobe, Quora.
--
