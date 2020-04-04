152. Maximum Product Subarray [M]
https://leetcode.com/problems/maximum-product-subarray/

/* Solution 1:
Using Dynamic Programming and Kadane's Algorithm.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int maxSoFar = nums[0];
        int tmp;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                tmp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = tmp;
            }

            maxEndingHere = Math.max(maxEndingHere * nums[i], nums[i]);
            minEndingHere = Math.min(minEndingHere * nums[i], nums[i]);

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }
}

--
Time Complexity: O(n), where n is number of elements in the array.
Space Complexity: O(1), Only constant space is used.
--
Asked by:
--
