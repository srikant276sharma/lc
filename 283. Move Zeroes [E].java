283. Move Zeroes [E]
https://leetcode.com/problems/move-zeroes/
Kevin: https://www.youtube.com/watch?v=1PEncepEIoE

/* Solution 1:
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        /*At first, move all non-zero elements to the start of the array.*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        /*Then set 0's after non-zero elements.*/
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}

--
Space Complexity: O(1). Only constant space is used.
Time Complexity: O(n). The total operations (array writes) that code does is n (Total number of elements).
--
Asked by: Google, Facebook, Microsoft, SAP, Walmart Labs, Bloomberg.
--
