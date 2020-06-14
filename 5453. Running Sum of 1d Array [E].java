5453. Running Sum of 1d Array [E]
https://leetcode.com/problems/running-sum-of-1d-array/

/* Solution 1:

TC: O(N), where N = no. of elements in input array.
SC: O(1).

Asked by:
*/

class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
