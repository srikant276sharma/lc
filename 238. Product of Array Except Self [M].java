238. Product of Array Except Self [M]
https://leetcode.com/problems/product-of-array-except-self/

/* Solution 1:
IDeserve: https://www.youtube.com/watch?v=vB-81TB6GUc
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        /*Traverse from left. */
        int left = 1;
        for (int i = 0; i < len; i++) {
            result[i] = left;
            left = left * nums[i];
        }

        /*Traverse from right. */
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }
}

--
Complexities:
Time: O(N).
Space: O(1).
--
Asked by: Amazon, LinkedIn, Apple, Facebook, Microsoft.
--
